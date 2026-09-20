/*
 * Copyright (C) 2012-2014 Neo Visionaries Inc.
 *
 * SPDX-License-Identifier: Apache-2.0
 */
package com.neovisionaries.i18n;

import java.util.List;
import java.util.regex.Pattern;
import org.junit.jupiter.api.Test;

import static com.neovisionaries.i18n.LanguageAlpha3Code.Usage.BIBLIOGRAPHY;
import static com.neovisionaries.i18n.LanguageAlpha3Code.Usage.COMMON;
import static com.neovisionaries.i18n.LanguageAlpha3Code.Usage.TERMINOLOGY;
import static com.neovisionaries.i18n.LanguageAlpha3Code.getByCode;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LanguageAlpha3CodeTest {
  @Test
  public void test1() {
    assertThat(getByCode(null)).isNull();
  }


  @Test
  public void test2() {
    assertThat(getByCode("")).isNull();
  }


  @Test
  public void test3() {
    assertThat(getByCode("?")).isNull();
  }


  @Test
  public void test4() {
    assertThat(getByCode("??")).isNull();
  }


  @Test
  public void test5() {
    assertThat(getByCode("???")).isNull();
  }


  @Test
  public void test6() {
    assertThat(getByCode("????")).isNull();
  }


  @Test
  public void test7() {
    assertThat(getByCode("jpn")).isSameAs(LanguageAlpha3Code.jpn);
  }


  @Test
  public void test8() {
    assertThat(getByCode("JPN")).isNull();
  }


  @Test
  public void test9() {
    assertThat(getByCode("jpn", true)).isSameAs(LanguageAlpha3Code.jpn);
  }


  @Test
  public void test10() {
    assertThat(getByCode("JPN", true)).isNull();
  }


  @Test
  public void test11() {
    assertThat(getByCode("jpn", false)).isSameAs(LanguageAlpha3Code.jpn);
  }


  @Test
  public void test12() {
    assertThat(getByCode("JPN", false)).isSameAs(LanguageAlpha3Code.jpn);
  }


  @Test
  public void test13() {
    assertThat(getByCode("he")).isSameAs(LanguageAlpha3Code.heb);
  }


  @Test
  public void test14() {
    assertThat(getByCode("iw")).isSameAs(LanguageAlpha3Code.heb);
  }


  @Test
  public void test15() {
    assertThat(getByCode("yi")).isSameAs(LanguageAlpha3Code.yid);
  }


  @Test
  public void test16() {
    assertThat(getByCode("ji")).isSameAs(LanguageAlpha3Code.yid);
  }


  @Test
  public void test17() {
    assertThat(getByCode("id")).isSameAs(LanguageAlpha3Code.ind);
  }


  @Test
  public void test18() {
    assertThat(getByCode("in")).isSameAs(LanguageAlpha3Code.ind);
  }


  @Test
  public void test19() {
    assertThat(LanguageAlpha3Code.bod.getSynonym()).isSameAs(LanguageAlpha3Code.tib);
  }


  @Test
  public void test20() {
    assertThat(LanguageAlpha3Code.bod.getAlpha3T()).isSameAs(LanguageAlpha3Code.bod);
  }


  @Test
  public void test21() {
    assertThat(LanguageAlpha3Code.bod.getAlpha3B()).isSameAs(LanguageAlpha3Code.tib);
  }


  @Test
  public void test22() {
    assertThat(LanguageAlpha3Code.bod.getUsage()).isSameAs(TERMINOLOGY);
  }


  @Test
  public void test23() {
    assertThat(LanguageAlpha3Code.tib.getSynonym()).isSameAs(LanguageAlpha3Code.bod);
  }


  @Test
  public void test24() {
    assertThat(LanguageAlpha3Code.tib.getAlpha3T()).isSameAs(LanguageAlpha3Code.bod);
  }


  @Test
  public void test25() {
    assertThat(LanguageAlpha3Code.tib.getAlpha3B()).isSameAs(LanguageAlpha3Code.tib);
  }


  @Test
  public void test26() {
    assertThat(LanguageAlpha3Code.tib.getUsage()).isSameAs(BIBLIOGRAPHY);
  }


  @Test
  public void test27() {
    assertThat(LanguageAlpha3Code.eus.getSynonym()).isSameAs(LanguageAlpha3Code.baq);
  }


  @Test
  public void test28() {
    assertThat(LanguageAlpha3Code.eus.getAlpha3T()).isSameAs(LanguageAlpha3Code.eus);
  }


  @Test
  public void test29() {
    assertThat(LanguageAlpha3Code.eus.getAlpha3B()).isSameAs(LanguageAlpha3Code.baq);
  }


  @Test
  public void test30() {
    assertThat(LanguageAlpha3Code.eus.getUsage()).isSameAs(TERMINOLOGY);
  }


  @Test
  public void test31() {
    assertThat(LanguageAlpha3Code.baq.getSynonym()).isSameAs(LanguageAlpha3Code.eus);
  }


  @Test
  public void test32() {
    assertThat(LanguageAlpha3Code.baq.getAlpha3T()).isSameAs(LanguageAlpha3Code.eus);
  }


  @Test
  public void test33() {
    assertThat(LanguageAlpha3Code.baq.getAlpha3B()).isSameAs(LanguageAlpha3Code.baq);
  }


  @Test
  public void test34() {
    assertThat(LanguageAlpha3Code.baq.getUsage()).isSameAs(BIBLIOGRAPHY);
  }


  @Test
  public void test35() {
    assertThat(LanguageAlpha3Code.ces.getSynonym()).isSameAs(LanguageAlpha3Code.cze);
  }


  @Test
  public void test36() {
    assertThat(LanguageAlpha3Code.ces.getAlpha3T()).isSameAs(LanguageAlpha3Code.ces);
  }


  @Test
  public void test37() {
    assertThat(LanguageAlpha3Code.ces.getAlpha3B()).isSameAs(LanguageAlpha3Code.cze);
  }


  @Test
  public void test38() {
    assertThat(LanguageAlpha3Code.ces.getUsage()).isSameAs(TERMINOLOGY);
  }


  @Test
  public void test39() {
    assertThat(LanguageAlpha3Code.cze.getSynonym()).isSameAs(LanguageAlpha3Code.ces);
  }


  @Test
  public void test40() {
    assertThat(LanguageAlpha3Code.cze.getAlpha3T()).isSameAs(LanguageAlpha3Code.ces);
  }


  @Test
  public void test41() {
    assertThat(LanguageAlpha3Code.cze.getAlpha3B()).isSameAs(LanguageAlpha3Code.cze);
  }


  @Test
  public void test42() {
    assertThat(LanguageAlpha3Code.cze.getUsage()).isSameAs(BIBLIOGRAPHY);
  }


  @Test
  public void test43() {
    assertThat(LanguageAlpha3Code.cym.getSynonym()).isSameAs(LanguageAlpha3Code.wel);
  }


  @Test
  public void test44() {
    assertThat(LanguageAlpha3Code.cym.getAlpha3T()).isSameAs(LanguageAlpha3Code.cym);
  }


  @Test
  public void test45() {
    assertThat(LanguageAlpha3Code.cym.getAlpha3B()).isSameAs(LanguageAlpha3Code.wel);
  }


  @Test
  public void test46() {
    assertThat(LanguageAlpha3Code.cym.getUsage()).isSameAs(TERMINOLOGY);
  }


  @Test
  public void test47() {
    assertThat(LanguageAlpha3Code.wel.getSynonym()).isSameAs(LanguageAlpha3Code.cym);
  }


  @Test
  public void test48() {
    assertThat(LanguageAlpha3Code.wel.getAlpha3T()).isSameAs(LanguageAlpha3Code.cym);
  }


  @Test
  public void test49() {
    assertThat(LanguageAlpha3Code.wel.getAlpha3B()).isSameAs(LanguageAlpha3Code.wel);
  }


  @Test
  public void test50() {
    assertThat(LanguageAlpha3Code.wel.getUsage()).isSameAs(BIBLIOGRAPHY);
  }


  @Test
  public void test51() {
    assertThat(LanguageAlpha3Code.deu.getSynonym()).isSameAs(LanguageAlpha3Code.ger);
  }


  @Test
  public void test52() {
    assertThat(LanguageAlpha3Code.deu.getAlpha3T()).isSameAs(LanguageAlpha3Code.deu);
  }


  @Test
  public void test53() {
    assertThat(LanguageAlpha3Code.deu.getAlpha3B()).isSameAs(LanguageAlpha3Code.ger);
  }


  @Test
  public void test54() {
    assertThat(LanguageAlpha3Code.deu.getUsage()).isSameAs(TERMINOLOGY);
  }


  @Test
  public void test55() {
    assertThat(LanguageAlpha3Code.ger.getSynonym()).isSameAs(LanguageAlpha3Code.deu);
  }


  @Test
  public void test56() {
    assertThat(LanguageAlpha3Code.ger.getAlpha3T()).isSameAs(LanguageAlpha3Code.deu);
  }


  @Test
  public void test57() {
    assertThat(LanguageAlpha3Code.ger.getAlpha3B()).isSameAs(LanguageAlpha3Code.ger);
  }


  @Test
  public void test58() {
    assertThat(LanguageAlpha3Code.ger.getUsage()).isSameAs(BIBLIOGRAPHY);
  }


  @Test
  public void test59() {
    assertThat(LanguageAlpha3Code.ell.getSynonym()).isSameAs(LanguageAlpha3Code.gre);
  }


  @Test
  public void test60() {
    assertThat(LanguageAlpha3Code.ell.getAlpha3T()).isSameAs(LanguageAlpha3Code.ell);
  }


  @Test
  public void test61() {
    assertThat(LanguageAlpha3Code.ell.getAlpha3B()).isSameAs(LanguageAlpha3Code.gre);
  }


  @Test
  public void test62() {
    assertThat(LanguageAlpha3Code.ell.getUsage()).isSameAs(TERMINOLOGY);
  }


  @Test
  public void test63() {
    assertThat(LanguageAlpha3Code.gre.getSynonym()).isSameAs(LanguageAlpha3Code.ell);
  }


  @Test
  public void test64() {
    assertThat(LanguageAlpha3Code.gre.getAlpha3T()).isSameAs(LanguageAlpha3Code.ell);
  }


  @Test
  public void test65() {
    assertThat(LanguageAlpha3Code.gre.getAlpha3B()).isSameAs(LanguageAlpha3Code.gre);
  }


  @Test
  public void test66() {
    assertThat(LanguageAlpha3Code.gre.getUsage()).isSameAs(BIBLIOGRAPHY);
  }


  @Test
  public void test67() {
    assertThat(LanguageAlpha3Code.fas.getSynonym()).isSameAs(LanguageAlpha3Code.per);
  }


  @Test
  public void test68() {
    assertThat(LanguageAlpha3Code.fas.getAlpha3T()).isSameAs(LanguageAlpha3Code.fas);
  }


  @Test
  public void test69() {
    assertThat(LanguageAlpha3Code.fas.getAlpha3B()).isSameAs(LanguageAlpha3Code.per);
  }


  @Test
  public void test70() {
    assertThat(LanguageAlpha3Code.fas.getUsage()).isSameAs(TERMINOLOGY);
  }


  @Test
  public void test71() {
    assertThat(LanguageAlpha3Code.per.getSynonym()).isSameAs(LanguageAlpha3Code.fas);
  }


  @Test
  public void test72() {
    assertThat(LanguageAlpha3Code.per.getAlpha3T()).isSameAs(LanguageAlpha3Code.fas);
  }


  @Test
  public void test73() {
    assertThat(LanguageAlpha3Code.per.getAlpha3B()).isSameAs(LanguageAlpha3Code.per);
  }


  @Test
  public void test74() {
    assertThat(LanguageAlpha3Code.per.getUsage()).isSameAs(BIBLIOGRAPHY);
  }


  @Test
  public void test75() {
    assertThat(LanguageAlpha3Code.fra.getSynonym()).isSameAs(LanguageAlpha3Code.fre);
  }


  @Test
  public void test76() {
    assertThat(LanguageAlpha3Code.fra.getAlpha3T()).isSameAs(LanguageAlpha3Code.fra);
  }


  @Test
  public void test77() {
    assertThat(LanguageAlpha3Code.fra.getAlpha3B()).isSameAs(LanguageAlpha3Code.fre);
  }


  @Test
  public void test78() {
    assertThat(LanguageAlpha3Code.fra.getUsage()).isSameAs(TERMINOLOGY);
  }


  @Test
  public void test79() {
    assertThat(LanguageAlpha3Code.fre.getSynonym()).isSameAs(LanguageAlpha3Code.fra);
  }


  @Test
  public void test80() {
    assertThat(LanguageAlpha3Code.fre.getAlpha3T()).isSameAs(LanguageAlpha3Code.fra);
  }


  @Test
  public void test81() {
    assertThat(LanguageAlpha3Code.fre.getAlpha3B()).isSameAs(LanguageAlpha3Code.fre);
  }


  @Test
  public void test82() {
    assertThat(LanguageAlpha3Code.fre.getUsage()).isSameAs(BIBLIOGRAPHY);
  }


  @Test
  public void test83() {
    assertThat(LanguageAlpha3Code.hye.getSynonym()).isSameAs(LanguageAlpha3Code.arm);
  }


  @Test
  public void test84() {
    assertThat(LanguageAlpha3Code.hye.getAlpha3T()).isSameAs(LanguageAlpha3Code.hye);
  }


  @Test
  public void test85() {
    assertThat(LanguageAlpha3Code.hye.getAlpha3B()).isSameAs(LanguageAlpha3Code.arm);
  }


  @Test
  public void test86() {
    assertThat(LanguageAlpha3Code.hye.getUsage()).isSameAs(TERMINOLOGY);
  }


  @Test
  public void test87() {
    assertThat(LanguageAlpha3Code.arm.getSynonym()).isSameAs(LanguageAlpha3Code.hye);
  }


  @Test
  public void test88() {
    assertThat(LanguageAlpha3Code.arm.getAlpha3T()).isSameAs(LanguageAlpha3Code.hye);
  }


  @Test
  public void test89() {
    assertThat(LanguageAlpha3Code.arm.getAlpha3B()).isSameAs(LanguageAlpha3Code.arm);
  }


  @Test
  public void test90() {
    assertThat(LanguageAlpha3Code.arm.getUsage()).isSameAs(BIBLIOGRAPHY);
  }


  @Test
  public void test91() {
    assertThat(LanguageAlpha3Code.isl.getSynonym()).isSameAs(LanguageAlpha3Code.ice);
  }


  @Test
  public void test92() {
    assertThat(LanguageAlpha3Code.isl.getAlpha3T()).isSameAs(LanguageAlpha3Code.isl);
  }


  @Test
  public void test93() {
    assertThat(LanguageAlpha3Code.isl.getAlpha3B()).isSameAs(LanguageAlpha3Code.ice);
  }


  @Test
  public void test94() {
    assertThat(LanguageAlpha3Code.isl.getUsage()).isSameAs(TERMINOLOGY);
  }


  @Test
  public void test95() {
    assertThat(LanguageAlpha3Code.ice.getSynonym()).isSameAs(LanguageAlpha3Code.isl);
  }


  @Test
  public void test96() {
    assertThat(LanguageAlpha3Code.ice.getAlpha3T()).isSameAs(LanguageAlpha3Code.isl);
  }


  @Test
  public void test97() {
    assertThat(LanguageAlpha3Code.ice.getAlpha3B()).isSameAs(LanguageAlpha3Code.ice);
  }


  @Test
  public void test98() {
    assertThat(LanguageAlpha3Code.ice.getUsage()).isSameAs(BIBLIOGRAPHY);
  }


  @Test
  public void test99() {
    assertThat(LanguageAlpha3Code.kat.getSynonym()).isSameAs(LanguageAlpha3Code.geo);
  }


  @Test
  public void test100() {
    assertThat(LanguageAlpha3Code.kat.getAlpha3T()).isSameAs(LanguageAlpha3Code.kat);
  }


  @Test
  public void test101() {
    assertThat(LanguageAlpha3Code.kat.getAlpha3B()).isSameAs(LanguageAlpha3Code.geo);
  }


  @Test
  public void test102() {
    assertThat(LanguageAlpha3Code.kat.getUsage()).isSameAs(TERMINOLOGY);
  }


  @Test
  public void test103() {
    assertThat(LanguageAlpha3Code.geo.getSynonym()).isSameAs(LanguageAlpha3Code.kat);
  }


  @Test
  public void test104() {
    assertThat(LanguageAlpha3Code.geo.getAlpha3T()).isSameAs(LanguageAlpha3Code.kat);
  }


  @Test
  public void test105() {
    assertThat(LanguageAlpha3Code.geo.getAlpha3B()).isSameAs(LanguageAlpha3Code.geo);
  }


  @Test
  public void test106() {
    assertThat(LanguageAlpha3Code.geo.getUsage()).isSameAs(BIBLIOGRAPHY);
  }


  @Test
  public void test107() {
    assertThat(LanguageAlpha3Code.mri.getSynonym()).isSameAs(LanguageAlpha3Code.mao);
  }


  @Test
  public void test108() {
    assertThat(LanguageAlpha3Code.mri.getAlpha3T()).isSameAs(LanguageAlpha3Code.mri);
  }


  @Test
  public void test109() {
    assertThat(LanguageAlpha3Code.mri.getAlpha3B()).isSameAs(LanguageAlpha3Code.mao);
  }


  @Test
  public void test110() {
    assertThat(LanguageAlpha3Code.mri.getUsage()).isSameAs(TERMINOLOGY);
  }


  @Test
  public void test111() {
    assertThat(LanguageAlpha3Code.mao.getSynonym()).isSameAs(LanguageAlpha3Code.mri);
  }


  @Test
  public void test112() {
    assertThat(LanguageAlpha3Code.mao.getAlpha3T()).isSameAs(LanguageAlpha3Code.mri);
  }


  @Test
  public void test113() {
    assertThat(LanguageAlpha3Code.mao.getAlpha3B()).isSameAs(LanguageAlpha3Code.mao);
  }


  @Test
  public void test114() {
    assertThat(LanguageAlpha3Code.mao.getUsage()).isSameAs(BIBLIOGRAPHY);
  }


  @Test
  public void test115() {
    assertThat(LanguageAlpha3Code.mkd.getSynonym()).isSameAs(LanguageAlpha3Code.mac);
  }


  @Test
  public void test116() {
    assertThat(LanguageAlpha3Code.mkd.getAlpha3T()).isSameAs(LanguageAlpha3Code.mkd);
  }


  @Test
  public void test117() {
    assertThat(LanguageAlpha3Code.mkd.getAlpha3B()).isSameAs(LanguageAlpha3Code.mac);
  }


  @Test
  public void test118() {
    assertThat(LanguageAlpha3Code.mkd.getUsage()).isSameAs(TERMINOLOGY);
  }


  @Test
  public void test119() {
    assertThat(LanguageAlpha3Code.mac.getSynonym()).isSameAs(LanguageAlpha3Code.mkd);
  }


  @Test
  public void test120() {
    assertThat(LanguageAlpha3Code.mac.getAlpha3T()).isSameAs(LanguageAlpha3Code.mkd);
  }


  @Test
  public void test121() {
    assertThat(LanguageAlpha3Code.mac.getAlpha3B()).isSameAs(LanguageAlpha3Code.mac);
  }


  @Test
  public void test122() {
    assertThat(LanguageAlpha3Code.mac.getUsage()).isSameAs(BIBLIOGRAPHY);
  }


  @Test
  public void test123() {
    assertThat(LanguageAlpha3Code.msa.getSynonym()).isSameAs(LanguageAlpha3Code.may);
  }


  @Test
  public void test124() {
    assertThat(LanguageAlpha3Code.msa.getAlpha3T()).isSameAs(LanguageAlpha3Code.msa);
  }


  @Test
  public void test125() {
    assertThat(LanguageAlpha3Code.msa.getAlpha3B()).isSameAs(LanguageAlpha3Code.may);
  }


  @Test
  public void test126() {
    assertThat(LanguageAlpha3Code.msa.getUsage()).isSameAs(TERMINOLOGY);
  }


  @Test
  public void test127() {
    assertThat(LanguageAlpha3Code.may.getSynonym()).isSameAs(LanguageAlpha3Code.msa);
  }


  @Test
  public void test128() {
    assertThat(LanguageAlpha3Code.may.getAlpha3T()).isSameAs(LanguageAlpha3Code.msa);
  }


  @Test
  public void test129() {
    assertThat(LanguageAlpha3Code.may.getAlpha3B()).isSameAs(LanguageAlpha3Code.may);
  }


  @Test
  public void test130() {
    assertThat(LanguageAlpha3Code.may.getUsage()).isSameAs(BIBLIOGRAPHY);
  }


  @Test
  public void test131() {
    assertThat(LanguageAlpha3Code.mya.getSynonym()).isSameAs(LanguageAlpha3Code.bur);
  }


  @Test
  public void test132() {
    assertThat(LanguageAlpha3Code.mya.getAlpha3T()).isSameAs(LanguageAlpha3Code.mya);
  }


  @Test
  public void test133() {
    assertThat(LanguageAlpha3Code.mya.getAlpha3B()).isSameAs(LanguageAlpha3Code.bur);
  }


  @Test
  public void test134() {
    assertThat(LanguageAlpha3Code.mya.getUsage()).isSameAs(TERMINOLOGY);
  }


  @Test
  public void test135() {
    assertThat(LanguageAlpha3Code.bur.getSynonym()).isSameAs(LanguageAlpha3Code.mya);
  }


  @Test
  public void test136() {
    assertThat(LanguageAlpha3Code.bur.getAlpha3T()).isSameAs(LanguageAlpha3Code.mya);
  }


  @Test
  public void test137() {
    assertThat(LanguageAlpha3Code.bur.getAlpha3B()).isSameAs(LanguageAlpha3Code.bur);
  }


  @Test
  public void test138() {
    assertThat(LanguageAlpha3Code.bur.getUsage()).isSameAs(BIBLIOGRAPHY);
  }


  @Test
  public void test139() {
    assertThat(LanguageAlpha3Code.nld.getSynonym()).isSameAs(LanguageAlpha3Code.dut);
  }


  @Test
  public void test140() {
    assertThat(LanguageAlpha3Code.nld.getAlpha3T()).isSameAs(LanguageAlpha3Code.nld);
  }


  @Test
  public void test141() {
    assertThat(LanguageAlpha3Code.nld.getAlpha3B()).isSameAs(LanguageAlpha3Code.dut);
  }


  @Test
  public void test142() {
    assertThat(LanguageAlpha3Code.nld.getUsage()).isSameAs(TERMINOLOGY);
  }


  @Test
  public void test143() {
    assertThat(LanguageAlpha3Code.dut.getSynonym()).isSameAs(LanguageAlpha3Code.nld);
  }


  @Test
  public void test144() {
    assertThat(LanguageAlpha3Code.dut.getAlpha3T()).isSameAs(LanguageAlpha3Code.nld);
  }


  @Test
  public void test145() {
    assertThat(LanguageAlpha3Code.dut.getAlpha3B()).isSameAs(LanguageAlpha3Code.dut);
  }


  @Test
  public void test146() {
    assertThat(LanguageAlpha3Code.dut.getUsage()).isSameAs(BIBLIOGRAPHY);
  }


  @Test
  public void test147() {
    assertThat(LanguageAlpha3Code.ron.getSynonym()).isSameAs(LanguageAlpha3Code.rum);
  }


  @Test
  public void test148() {
    assertThat(LanguageAlpha3Code.ron.getAlpha3T()).isSameAs(LanguageAlpha3Code.ron);
  }


  @Test
  public void test149() {
    assertThat(LanguageAlpha3Code.ron.getAlpha3B()).isSameAs(LanguageAlpha3Code.rum);
  }


  @Test
  public void test150() {
    assertThat(LanguageAlpha3Code.ron.getUsage()).isSameAs(TERMINOLOGY);
  }


  @Test
  public void test151() {
    assertThat(LanguageAlpha3Code.rum.getSynonym()).isSameAs(LanguageAlpha3Code.ron);
  }


  @Test
  public void test152() {
    assertThat(LanguageAlpha3Code.rum.getAlpha3T()).isSameAs(LanguageAlpha3Code.ron);
  }


  @Test
  public void test153() {
    assertThat(LanguageAlpha3Code.rum.getAlpha3B()).isSameAs(LanguageAlpha3Code.rum);
  }


  @Test
  public void test154() {
    assertThat(LanguageAlpha3Code.rum.getUsage()).isSameAs(BIBLIOGRAPHY);
  }


  @Test
  public void test155() {
    assertThat(LanguageAlpha3Code.slk.getSynonym()).isSameAs(LanguageAlpha3Code.slo);
  }


  @Test
  public void test156() {
    assertThat(LanguageAlpha3Code.slk.getAlpha3T()).isSameAs(LanguageAlpha3Code.slk);
  }


  @Test
  public void test157() {
    assertThat(LanguageAlpha3Code.slk.getAlpha3B()).isSameAs(LanguageAlpha3Code.slo);
  }


  @Test
  public void test158() {
    assertThat(LanguageAlpha3Code.slk.getUsage()).isSameAs(TERMINOLOGY);
  }


  @Test
  public void test159() {
    assertThat(LanguageAlpha3Code.slo.getSynonym()).isSameAs(LanguageAlpha3Code.slk);
  }


  @Test
  public void test160() {
    assertThat(LanguageAlpha3Code.slo.getAlpha3T()).isSameAs(LanguageAlpha3Code.slk);
  }


  @Test
  public void test161() {
    assertThat(LanguageAlpha3Code.slo.getAlpha3B()).isSameAs(LanguageAlpha3Code.slo);
  }


  @Test
  public void test162() {
    assertThat(LanguageAlpha3Code.slo.getUsage()).isSameAs(BIBLIOGRAPHY);
  }


  @Test
  public void test163() {
    assertThat(LanguageAlpha3Code.sqi.getSynonym()).isSameAs(LanguageAlpha3Code.alb);
  }


  @Test
  public void test164() {
    assertThat(LanguageAlpha3Code.sqi.getAlpha3T()).isSameAs(LanguageAlpha3Code.sqi);
  }


  @Test
  public void test165() {
    assertThat(LanguageAlpha3Code.sqi.getAlpha3B()).isSameAs(LanguageAlpha3Code.alb);
  }


  @Test
  public void test166() {
    assertThat(LanguageAlpha3Code.sqi.getUsage()).isSameAs(TERMINOLOGY);
  }


  @Test
  public void test167() {
    assertThat(LanguageAlpha3Code.alb.getSynonym()).isSameAs(LanguageAlpha3Code.sqi);
  }


  @Test
  public void test168() {
    assertThat(LanguageAlpha3Code.alb.getAlpha3T()).isSameAs(LanguageAlpha3Code.sqi);
  }


  @Test
  public void test169() {
    assertThat(LanguageAlpha3Code.alb.getAlpha3B()).isSameAs(LanguageAlpha3Code.alb);
  }


  @Test
  public void test170() {
    assertThat(LanguageAlpha3Code.alb.getUsage()).isSameAs(BIBLIOGRAPHY);
  }


  @Test
  public void test171() {
    assertThat(LanguageAlpha3Code.jpn.getSynonym()).isSameAs(LanguageAlpha3Code.jpn);
  }


  @Test
  public void test172() {
    assertThat(LanguageAlpha3Code.jpn.getAlpha3T()).isSameAs(LanguageAlpha3Code.jpn);
  }


  @Test
  public void test173() {
    assertThat(LanguageAlpha3Code.jpn.getAlpha3B()).isSameAs(LanguageAlpha3Code.jpn);
  }


  @Test
  public void test174() {
    assertThat(LanguageAlpha3Code.jpn.getUsage()).isSameAs(COMMON);
  }


  @Test
  public void test175() {
    assertThat(LanguageAlpha3Code.jpn.getName()).isSameAs("Japanese");
  }


  @Test
  public void test176() {
    assertThat(getByCode("New", true)).isSameAs(LanguageAlpha3Code.New);
  }


  @Test
  public void test177() {
    assertThat(getByCode("new", true)).isSameAs(LanguageAlpha3Code.New);
  }


  @Test
  public void test178() {
    assertThat(getByCode("NEW", true)).isNull();
  }


  @Test
  public void test179() {
    assertThat(LanguageAlpha3Code.New.toString()).isEqualTo("new");
  }


  @Test
  public void test180() {
    List<LanguageAlpha3Code> list = LanguageAlpha3Code.findByName("Old.*");

    assertThat(list).hasSize(7);

    // ang : Old English
    assertThat(list).contains(LanguageAlpha3Code.ang);

    // fro : Old French
    assertThat(list).contains(LanguageAlpha3Code.fro);

    // goh : Old High German
    assertThat(list).contains(LanguageAlpha3Code.goh);

    // non : Old Norse
    assertThat(list).contains(LanguageAlpha3Code.non);

    // peo : Old Persian
    assertThat(list).contains(LanguageAlpha3Code.peo);

    // pro : Old Provencal
    assertThat(list).contains(LanguageAlpha3Code.pro);

    // sga : Old Irish
    assertThat(list).contains(LanguageAlpha3Code.fro);
  }


  @Test
  public void test181() {
    assertThat(getByCode("undefined")).isSameAs(LanguageAlpha3Code.undefined);
  }


  @Test
  public void test182() {
    assertThat(getByCode("UNDEFINED")).isNull();
  }


  @Test
  public void test183() {
    assertThat(getByCode("UNDEFINED", false)).isSameAs(LanguageAlpha3Code.undefined);
  }

  @Test
  public void chineseOverrides() {
    assertThat(LanguageAlpha3Code.chi.getAlpha2()).isEqualTo(LanguageCode.zh);
    assertThat(LanguageAlpha3Code.chi.getUsage()).isEqualTo(BIBLIOGRAPHY);
    assertThat(LanguageAlpha3Code.chi.getSynonym()).isEqualTo(LanguageAlpha3Code.zho);

    assertThat(LanguageAlpha3Code.zho.getAlpha2()).isEqualTo(LanguageCode.zh);
    assertThat(LanguageAlpha3Code.zho.getUsage()).isEqualTo(TERMINOLOGY);
    assertThat(LanguageAlpha3Code.zho.getSynonym()).isEqualTo(LanguageAlpha3Code.chi);
  }

  @Test
  public void getByCodeIgnoreCaseWithValudValue() {
    assertThat(LanguageAlpha3Code.getByCodeIgnoreCase("eng")).isEqualTo(LanguageAlpha3Code.eng);
  }

  @Test
  public void canonicalizeReturnsNullWhenPassedNull() {
    assertThat(LanguageAlpha3Code.getByCode(null, true)).isNull();
  }

  @Test
  public void canonicalizeReturnsNullWhenPassedEmptyString() {
    assertThat(LanguageAlpha3Code.getByCode("", true)).isNull();
  }

  @Test
  public void findByNameThrowsExceptionWhenPassedNull() {
    Pattern pattern = null;
    assertThatThrownBy(() -> LanguageAlpha3Code.findByName(pattern))
      .isInstanceOf(IllegalArgumentException.class);
  }
}
