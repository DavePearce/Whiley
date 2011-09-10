// This file was automatically generated.
package wyil.testing;
import org.junit.*;
import static org.junit.Assert.*;
import wyil.lang.Type;

public class SubtypeTests {
	@Test public void test_1() {
		checkIsSubtype("any","any");
	}
	@Test public void test_2() {
		checkIsSubtype("any","null");
	}
	@Test public void test_3() {
		checkIsSubtype("any","int");
	}
	@Test public void test_4() {
		checkIsSubtype("any","[void]");
	}
	@Test public void test_5() {
		checkIsSubtype("any","[any]");
	}
	@Test public void test_6() {
		checkIsSubtype("any","[null]");
	}
	@Test public void test_7() {
		checkIsSubtype("any","[int]");
	}
	@Test public void test_8() {
		checkIsSubtype("any","!void");
	}
	@Test public void test_9() {
		checkIsSubtype("any","!any");
	}
	@Test public void test_10() {
		checkIsSubtype("any","!null");
	}
	@Test public void test_11() {
		checkIsSubtype("any","!int");
	}
	@Test public void test_12() {
		checkIsSubtype("any","[[void]]");
	}
	@Test public void test_13() {
		checkIsSubtype("any","[[any]]");
	}
	@Test public void test_14() {
		checkIsSubtype("any","[[null]]");
	}
	@Test public void test_15() {
		checkIsSubtype("any","[[int]]");
	}
	@Test public void test_16() {
		checkIsSubtype("any","[!void]");
	}
	@Test public void test_17() {
		checkIsSubtype("any","[!any]");
	}
	@Test public void test_18() {
		checkIsSubtype("any","[!null]");
	}
	@Test public void test_19() {
		checkIsSubtype("any","[!int]");
	}
	@Test public void test_20() {
		checkIsSubtype("any","void|void");
	}
	@Test public void test_21() {
		checkIsSubtype("any","void|any");
	}
	@Test public void test_22() {
		checkIsSubtype("any","void|null");
	}
	@Test public void test_23() {
		checkIsSubtype("any","void|int");
	}
	@Test public void test_24() {
		checkIsSubtype("any","any|void");
	}
	@Test public void test_25() {
		checkIsSubtype("any","any|any");
	}
	@Test public void test_26() {
		checkIsSubtype("any","any|null");
	}
	@Test public void test_27() {
		checkIsSubtype("any","any|int");
	}
	@Test public void test_28() {
		checkIsSubtype("any","null|void");
	}
	@Test public void test_29() {
		checkIsSubtype("any","null|any");
	}
	@Test public void test_30() {
		checkIsSubtype("any","null|null");
	}
	@Test public void test_31() {
		checkIsSubtype("any","null|int");
	}
	@Test public void test_32() {
		checkIsSubtype("any","int|void");
	}
	@Test public void test_33() {
		checkIsSubtype("any","int|any");
	}
	@Test public void test_34() {
		checkIsSubtype("any","int|null");
	}
	@Test public void test_35() {
		checkIsSubtype("any","int|int");
	}
	@Test public void test_36() {
		checkIsSubtype("any","[void]|void");
	}
	@Test public void test_37() {
		checkIsSubtype("any","[any]|any");
	}
	@Test public void test_38() {
		checkIsSubtype("any","[null]|null");
	}
	@Test public void test_39() {
		checkIsSubtype("any","[int]|int");
	}
	@Test public void test_40() {
		checkIsSubtype("any","!void|void");
	}
	@Test public void test_41() {
		checkIsSubtype("any","!any|any");
	}
	@Test public void test_42() {
		checkIsSubtype("any","!null|null");
	}
	@Test public void test_43() {
		checkIsSubtype("any","!int|int");
	}
	@Test public void test_44() {
		checkIsSubtype("any","![void]");
	}
	@Test public void test_45() {
		checkIsSubtype("any","![any]");
	}
	@Test public void test_46() {
		checkIsSubtype("any","![null]");
	}
	@Test public void test_47() {
		checkIsSubtype("any","![int]");
	}
	@Test public void test_48() {
		checkIsSubtype("any","!!void");
	}
	@Test public void test_49() {
		checkIsSubtype("any","!!any");
	}
	@Test public void test_50() {
		checkIsSubtype("any","!!null");
	}
	@Test public void test_51() {
		checkIsSubtype("any","!!int");
	}
	@Test public void test_52() {
		checkNotSubtype("null","any");
	}
	@Test public void test_53() {
		checkIsSubtype("null","null");
	}
	@Test public void test_54() {
		checkNotSubtype("null","int");
	}
	@Test public void test_55() {
		checkNotSubtype("null","[void]");
	}
	@Test public void test_56() {
		checkNotSubtype("null","[any]");
	}
	@Test public void test_57() {
		checkNotSubtype("null","[null]");
	}
	@Test public void test_58() {
		checkNotSubtype("null","[int]");
	}
	@Test public void test_59() {
		checkNotSubtype("null","!void");
	}
	@Test public void test_60() {
		checkIsSubtype("null","!any");
	}
	@Test public void test_61() {
		checkNotSubtype("null","!null");
	}
	@Test public void test_62() {
		checkNotSubtype("null","!int");
	}
	@Test public void test_63() {
		checkNotSubtype("null","[[void]]");
	}
	@Test public void test_64() {
		checkNotSubtype("null","[[any]]");
	}
	@Test public void test_65() {
		checkNotSubtype("null","[[null]]");
	}
	@Test public void test_66() {
		checkNotSubtype("null","[[int]]");
	}
	@Test public void test_67() {
		checkNotSubtype("null","[!void]");
	}
	@Test public void test_68() {
		checkNotSubtype("null","[!any]");
	}
	@Test public void test_69() {
		checkNotSubtype("null","[!null]");
	}
	@Test public void test_70() {
		checkNotSubtype("null","[!int]");
	}
	@Test public void test_71() {
		checkIsSubtype("null","void|void");
	}
	@Test public void test_72() {
		checkNotSubtype("null","void|any");
	}
	@Test public void test_73() {
		checkIsSubtype("null","void|null");
	}
	@Test public void test_74() {
		checkNotSubtype("null","void|int");
	}
	@Test public void test_75() {
		checkNotSubtype("null","any|void");
	}
	@Test public void test_76() {
		checkNotSubtype("null","any|any");
	}
	@Test public void test_77() {
		checkNotSubtype("null","any|null");
	}
	@Test public void test_78() {
		checkNotSubtype("null","any|int");
	}
	@Test public void test_79() {
		checkIsSubtype("null","null|void");
	}
	@Test public void test_80() {
		checkNotSubtype("null","null|any");
	}
	@Test public void test_81() {
		checkIsSubtype("null","null|null");
	}
	@Test public void test_82() {
		checkNotSubtype("null","null|int");
	}
	@Test public void test_83() {
		checkNotSubtype("null","int|void");
	}
	@Test public void test_84() {
		checkNotSubtype("null","int|any");
	}
	@Test public void test_85() {
		checkNotSubtype("null","int|null");
	}
	@Test public void test_86() {
		checkNotSubtype("null","int|int");
	}
	@Test public void test_87() {
		checkNotSubtype("null","[void]|void");
	}
	@Test public void test_88() {
		checkNotSubtype("null","[any]|any");
	}
	@Test public void test_89() {
		checkNotSubtype("null","[null]|null");
	}
	@Test public void test_90() {
		checkNotSubtype("null","[int]|int");
	}
	@Test public void test_91() {
		checkNotSubtype("null","!void|void");
	}
	@Test public void test_92() {
		checkNotSubtype("null","!any|any");
	}
	@Test public void test_93() {
		checkNotSubtype("null","!null|null");
	}
	@Test public void test_94() {
		checkNotSubtype("null","!int|int");
	}
	@Test public void test_95() {
		checkNotSubtype("null","![void]");
	}
	@Test public void test_96() {
		checkNotSubtype("null","![any]");
	}
	@Test public void test_97() {
		checkNotSubtype("null","![null]");
	}
	@Test public void test_98() {
		checkNotSubtype("null","![int]");
	}
	@Test public void test_99() {
		checkIsSubtype("null","!!void");
	}
	@Test public void test_100() {
		checkNotSubtype("null","!!any");
	}
	@Test public void test_101() {
		checkIsSubtype("null","!!null");
	}
	@Test public void test_102() {
		checkNotSubtype("null","!!int");
	}
	@Test public void test_103() {
		checkNotSubtype("int","any");
	}
	@Test public void test_104() {
		checkNotSubtype("int","null");
	}
	@Test public void test_105() {
		checkIsSubtype("int","int");
	}
	@Test public void test_106() {
		checkNotSubtype("int","[void]");
	}
	@Test public void test_107() {
		checkNotSubtype("int","[any]");
	}
	@Test public void test_108() {
		checkNotSubtype("int","[null]");
	}
	@Test public void test_109() {
		checkNotSubtype("int","[int]");
	}
	@Test public void test_110() {
		checkNotSubtype("int","!void");
	}
	@Test public void test_111() {
		checkIsSubtype("int","!any");
	}
	@Test public void test_112() {
		checkNotSubtype("int","!null");
	}
	@Test public void test_113() {
		checkNotSubtype("int","!int");
	}
	@Test public void test_114() {
		checkNotSubtype("int","[[void]]");
	}
	@Test public void test_115() {
		checkNotSubtype("int","[[any]]");
	}
	@Test public void test_116() {
		checkNotSubtype("int","[[null]]");
	}
	@Test public void test_117() {
		checkNotSubtype("int","[[int]]");
	}
	@Test public void test_118() {
		checkNotSubtype("int","[!void]");
	}
	@Test public void test_119() {
		checkNotSubtype("int","[!any]");
	}
	@Test public void test_120() {
		checkNotSubtype("int","[!null]");
	}
	@Test public void test_121() {
		checkNotSubtype("int","[!int]");
	}
	@Test public void test_122() {
		checkIsSubtype("int","void|void");
	}
	@Test public void test_123() {
		checkNotSubtype("int","void|any");
	}
	@Test public void test_124() {
		checkNotSubtype("int","void|null");
	}
	@Test public void test_125() {
		checkIsSubtype("int","void|int");
	}
	@Test public void test_126() {
		checkNotSubtype("int","any|void");
	}
	@Test public void test_127() {
		checkNotSubtype("int","any|any");
	}
	@Test public void test_128() {
		checkNotSubtype("int","any|null");
	}
	@Test public void test_129() {
		checkNotSubtype("int","any|int");
	}
	@Test public void test_130() {
		checkNotSubtype("int","null|void");
	}
	@Test public void test_131() {
		checkNotSubtype("int","null|any");
	}
	@Test public void test_132() {
		checkNotSubtype("int","null|null");
	}
	@Test public void test_133() {
		checkNotSubtype("int","null|int");
	}
	@Test public void test_134() {
		checkIsSubtype("int","int|void");
	}
	@Test public void test_135() {
		checkNotSubtype("int","int|any");
	}
	@Test public void test_136() {
		checkNotSubtype("int","int|null");
	}
	@Test public void test_137() {
		checkIsSubtype("int","int|int");
	}
	@Test public void test_138() {
		checkNotSubtype("int","[void]|void");
	}
	@Test public void test_139() {
		checkNotSubtype("int","[any]|any");
	}
	@Test public void test_140() {
		checkNotSubtype("int","[null]|null");
	}
	@Test public void test_141() {
		checkNotSubtype("int","[int]|int");
	}
	@Test public void test_142() {
		checkNotSubtype("int","!void|void");
	}
	@Test public void test_143() {
		checkNotSubtype("int","!any|any");
	}
	@Test public void test_144() {
		checkNotSubtype("int","!null|null");
	}
	@Test public void test_145() {
		checkNotSubtype("int","!int|int");
	}
	@Test public void test_146() {
		checkNotSubtype("int","![void]");
	}
	@Test public void test_147() {
		checkNotSubtype("int","![any]");
	}
	@Test public void test_148() {
		checkNotSubtype("int","![null]");
	}
	@Test public void test_149() {
		checkNotSubtype("int","![int]");
	}
	@Test public void test_150() {
		checkIsSubtype("int","!!void");
	}
	@Test public void test_151() {
		checkNotSubtype("int","!!any");
	}
	@Test public void test_152() {
		checkNotSubtype("int","!!null");
	}
	@Test public void test_153() {
		checkIsSubtype("int","!!int");
	}
	@Test public void test_154() {
		checkNotSubtype("[void]","any");
	}
	@Test public void test_155() {
		checkNotSubtype("[void]","null");
	}
	@Test public void test_156() {
		checkNotSubtype("[void]","int");
	}
	@Test public void test_157() {
		checkIsSubtype("[void]","[void]");
	}
	@Test public void test_158() {
		checkNotSubtype("[void]","[any]");
	}
	@Test public void test_159() {
		checkNotSubtype("[void]","[null]");
	}
	@Test public void test_160() {
		checkNotSubtype("[void]","[int]");
	}
	@Test public void test_161() {
		checkNotSubtype("[void]","!void");
	}
	@Test public void test_162() {
		checkIsSubtype("[void]","!any");
	}
	@Test public void test_163() {
		checkNotSubtype("[void]","!null");
	}
	@Test public void test_164() {
		checkNotSubtype("[void]","!int");
	}
	@Test public void test_165() {
		checkNotSubtype("[void]","[[void]]");
	}
	@Test public void test_166() {
		checkNotSubtype("[void]","[[any]]");
	}
	@Test public void test_167() {
		checkNotSubtype("[void]","[[null]]");
	}
	@Test public void test_168() {
		checkNotSubtype("[void]","[[int]]");
	}
	@Test public void test_169() {
		checkNotSubtype("[void]","[!void]");
	}
	@Test public void test_170() {
		checkIsSubtype("[void]","[!any]");
	}
	@Test public void test_171() {
		checkNotSubtype("[void]","[!null]");
	}
	@Test public void test_172() {
		checkNotSubtype("[void]","[!int]");
	}
	@Test public void test_173() {
		checkIsSubtype("[void]","void|void");
	}
	@Test public void test_174() {
		checkNotSubtype("[void]","void|any");
	}
	@Test public void test_175() {
		checkNotSubtype("[void]","void|null");
	}
	@Test public void test_176() {
		checkNotSubtype("[void]","void|int");
	}
	@Test public void test_177() {
		checkNotSubtype("[void]","any|void");
	}
	@Test public void test_178() {
		checkNotSubtype("[void]","any|any");
	}
	@Test public void test_179() {
		checkNotSubtype("[void]","any|null");
	}
	@Test public void test_180() {
		checkNotSubtype("[void]","any|int");
	}
	@Test public void test_181() {
		checkNotSubtype("[void]","null|void");
	}
	@Test public void test_182() {
		checkNotSubtype("[void]","null|any");
	}
	@Test public void test_183() {
		checkNotSubtype("[void]","null|null");
	}
	@Test public void test_184() {
		checkNotSubtype("[void]","null|int");
	}
	@Test public void test_185() {
		checkNotSubtype("[void]","int|void");
	}
	@Test public void test_186() {
		checkNotSubtype("[void]","int|any");
	}
	@Test public void test_187() {
		checkNotSubtype("[void]","int|null");
	}
	@Test public void test_188() {
		checkNotSubtype("[void]","int|int");
	}
	@Test public void test_189() {
		checkIsSubtype("[void]","[void]|void");
	}
	@Test public void test_190() {
		checkNotSubtype("[void]","[any]|any");
	}
	@Test public void test_191() {
		checkNotSubtype("[void]","[null]|null");
	}
	@Test public void test_192() {
		checkNotSubtype("[void]","[int]|int");
	}
	@Test public void test_193() {
		checkNotSubtype("[void]","!void|void");
	}
	@Test public void test_194() {
		checkNotSubtype("[void]","!any|any");
	}
	@Test public void test_195() {
		checkNotSubtype("[void]","!null|null");
	}
	@Test public void test_196() {
		checkNotSubtype("[void]","!int|int");
	}
	@Test public void test_197() {
		checkNotSubtype("[void]","![void]");
	}
	@Test public void test_198() {
		checkNotSubtype("[void]","![any]");
	}
	@Test public void test_199() {
		checkNotSubtype("[void]","![null]");
	}
	@Test public void test_200() {
		checkNotSubtype("[void]","![int]");
	}
	@Test public void test_201() {
		checkIsSubtype("[void]","!!void");
	}
	@Test public void test_202() {
		checkNotSubtype("[void]","!!any");
	}
	@Test public void test_203() {
		checkNotSubtype("[void]","!!null");
	}
	@Test public void test_204() {
		checkNotSubtype("[void]","!!int");
	}
	@Test public void test_205() {
		checkNotSubtype("[any]","any");
	}
	@Test public void test_206() {
		checkNotSubtype("[any]","null");
	}
	@Test public void test_207() {
		checkNotSubtype("[any]","int");
	}
	@Test public void test_208() {
		checkIsSubtype("[any]","[void]");
	}
	@Test public void test_209() {
		checkIsSubtype("[any]","[any]");
	}
	@Test public void test_210() {
		checkIsSubtype("[any]","[null]");
	}
	@Test public void test_211() {
		checkIsSubtype("[any]","[int]");
	}
	@Test public void test_212() {
		checkNotSubtype("[any]","!void");
	}
	@Test public void test_213() {
		checkIsSubtype("[any]","!any");
	}
	@Test public void test_214() {
		checkNotSubtype("[any]","!null");
	}
	@Test public void test_215() {
		checkNotSubtype("[any]","!int");
	}
	@Test public void test_216() {
		checkIsSubtype("[any]","[[void]]");
	}
	@Test public void test_217() {
		checkIsSubtype("[any]","[[any]]");
	}
	@Test public void test_218() {
		checkIsSubtype("[any]","[[null]]");
	}
	@Test public void test_219() {
		checkIsSubtype("[any]","[[int]]");
	}
	@Test public void test_220() {
		checkIsSubtype("[any]","[!void]");
	}
	@Test public void test_221() {
		checkIsSubtype("[any]","[!any]");
	}
	@Test public void test_222() {
		checkIsSubtype("[any]","[!null]");
	}
	@Test public void test_223() {
		checkIsSubtype("[any]","[!int]");
	}
	@Test public void test_224() {
		checkIsSubtype("[any]","void|void");
	}
	@Test public void test_225() {
		checkNotSubtype("[any]","void|any");
	}
	@Test public void test_226() {
		checkNotSubtype("[any]","void|null");
	}
	@Test public void test_227() {
		checkNotSubtype("[any]","void|int");
	}
	@Test public void test_228() {
		checkNotSubtype("[any]","any|void");
	}
	@Test public void test_229() {
		checkNotSubtype("[any]","any|any");
	}
	@Test public void test_230() {
		checkNotSubtype("[any]","any|null");
	}
	@Test public void test_231() {
		checkNotSubtype("[any]","any|int");
	}
	@Test public void test_232() {
		checkNotSubtype("[any]","null|void");
	}
	@Test public void test_233() {
		checkNotSubtype("[any]","null|any");
	}
	@Test public void test_234() {
		checkNotSubtype("[any]","null|null");
	}
	@Test public void test_235() {
		checkNotSubtype("[any]","null|int");
	}
	@Test public void test_236() {
		checkNotSubtype("[any]","int|void");
	}
	@Test public void test_237() {
		checkNotSubtype("[any]","int|any");
	}
	@Test public void test_238() {
		checkNotSubtype("[any]","int|null");
	}
	@Test public void test_239() {
		checkNotSubtype("[any]","int|int");
	}
	@Test public void test_240() {
		checkIsSubtype("[any]","[void]|void");
	}
	@Test public void test_241() {
		checkNotSubtype("[any]","[any]|any");
	}
	@Test public void test_242() {
		checkNotSubtype("[any]","[null]|null");
	}
	@Test public void test_243() {
		checkNotSubtype("[any]","[int]|int");
	}
	@Test public void test_244() {
		checkNotSubtype("[any]","!void|void");
	}
	@Test public void test_245() {
		checkNotSubtype("[any]","!any|any");
	}
	@Test public void test_246() {
		checkNotSubtype("[any]","!null|null");
	}
	@Test public void test_247() {
		checkNotSubtype("[any]","!int|int");
	}
	@Test public void test_248() {
		checkNotSubtype("[any]","![void]");
	}
	@Test public void test_249() {
		checkNotSubtype("[any]","![any]");
	}
	@Test public void test_250() {
		checkNotSubtype("[any]","![null]");
	}
	@Test public void test_251() {
		checkNotSubtype("[any]","![int]");
	}
	@Test public void test_252() {
		checkIsSubtype("[any]","!!void");
	}
	@Test public void test_253() {
		checkNotSubtype("[any]","!!any");
	}
	@Test public void test_254() {
		checkNotSubtype("[any]","!!null");
	}
	@Test public void test_255() {
		checkNotSubtype("[any]","!!int");
	}
	@Test public void test_256() {
		checkNotSubtype("[null]","any");
	}
	@Test public void test_257() {
		checkNotSubtype("[null]","null");
	}
	@Test public void test_258() {
		checkNotSubtype("[null]","int");
	}
	@Test public void test_259() {
		checkIsSubtype("[null]","[void]");
	}
	@Test public void test_260() {
		checkNotSubtype("[null]","[any]");
	}
	@Test public void test_261() {
		checkIsSubtype("[null]","[null]");
	}
	@Test public void test_262() {
		checkNotSubtype("[null]","[int]");
	}
	@Test public void test_263() {
		checkNotSubtype("[null]","!void");
	}
	@Test public void test_264() {
		checkIsSubtype("[null]","!any");
	}
	@Test public void test_265() {
		checkNotSubtype("[null]","!null");
	}
	@Test public void test_266() {
		checkNotSubtype("[null]","!int");
	}
	@Test public void test_267() {
		checkNotSubtype("[null]","[[void]]");
	}
	@Test public void test_268() {
		checkNotSubtype("[null]","[[any]]");
	}
	@Test public void test_269() {
		checkNotSubtype("[null]","[[null]]");
	}
	@Test public void test_270() {
		checkNotSubtype("[null]","[[int]]");
	}
	@Test public void test_271() {
		checkNotSubtype("[null]","[!void]");
	}
	@Test public void test_272() {
		checkIsSubtype("[null]","[!any]");
	}
	@Test public void test_273() {
		checkNotSubtype("[null]","[!null]");
	}
	@Test public void test_274() {
		checkNotSubtype("[null]","[!int]");
	}
	@Test public void test_275() {
		checkIsSubtype("[null]","void|void");
	}
	@Test public void test_276() {
		checkNotSubtype("[null]","void|any");
	}
	@Test public void test_277() {
		checkNotSubtype("[null]","void|null");
	}
	@Test public void test_278() {
		checkNotSubtype("[null]","void|int");
	}
	@Test public void test_279() {
		checkNotSubtype("[null]","any|void");
	}
	@Test public void test_280() {
		checkNotSubtype("[null]","any|any");
	}
	@Test public void test_281() {
		checkNotSubtype("[null]","any|null");
	}
	@Test public void test_282() {
		checkNotSubtype("[null]","any|int");
	}
	@Test public void test_283() {
		checkNotSubtype("[null]","null|void");
	}
	@Test public void test_284() {
		checkNotSubtype("[null]","null|any");
	}
	@Test public void test_285() {
		checkNotSubtype("[null]","null|null");
	}
	@Test public void test_286() {
		checkNotSubtype("[null]","null|int");
	}
	@Test public void test_287() {
		checkNotSubtype("[null]","int|void");
	}
	@Test public void test_288() {
		checkNotSubtype("[null]","int|any");
	}
	@Test public void test_289() {
		checkNotSubtype("[null]","int|null");
	}
	@Test public void test_290() {
		checkNotSubtype("[null]","int|int");
	}
	@Test public void test_291() {
		checkIsSubtype("[null]","[void]|void");
	}
	@Test public void test_292() {
		checkNotSubtype("[null]","[any]|any");
	}
	@Test public void test_293() {
		checkNotSubtype("[null]","[null]|null");
	}
	@Test public void test_294() {
		checkNotSubtype("[null]","[int]|int");
	}
	@Test public void test_295() {
		checkNotSubtype("[null]","!void|void");
	}
	@Test public void test_296() {
		checkNotSubtype("[null]","!any|any");
	}
	@Test public void test_297() {
		checkNotSubtype("[null]","!null|null");
	}
	@Test public void test_298() {
		checkNotSubtype("[null]","!int|int");
	}
	@Test public void test_299() {
		checkNotSubtype("[null]","![void]");
	}
	@Test public void test_300() {
		checkNotSubtype("[null]","![any]");
	}
	@Test public void test_301() {
		checkNotSubtype("[null]","![null]");
	}
	@Test public void test_302() {
		checkNotSubtype("[null]","![int]");
	}
	@Test public void test_303() {
		checkIsSubtype("[null]","!!void");
	}
	@Test public void test_304() {
		checkNotSubtype("[null]","!!any");
	}
	@Test public void test_305() {
		checkNotSubtype("[null]","!!null");
	}
	@Test public void test_306() {
		checkNotSubtype("[null]","!!int");
	}
	@Test public void test_307() {
		checkNotSubtype("[int]","any");
	}
	@Test public void test_308() {
		checkNotSubtype("[int]","null");
	}
	@Test public void test_309() {
		checkNotSubtype("[int]","int");
	}
	@Test public void test_310() {
		checkIsSubtype("[int]","[void]");
	}
	@Test public void test_311() {
		checkNotSubtype("[int]","[any]");
	}
	@Test public void test_312() {
		checkNotSubtype("[int]","[null]");
	}
	@Test public void test_313() {
		checkIsSubtype("[int]","[int]");
	}
	@Test public void test_314() {
		checkNotSubtype("[int]","!void");
	}
	@Test public void test_315() {
		checkIsSubtype("[int]","!any");
	}
	@Test public void test_316() {
		checkNotSubtype("[int]","!null");
	}
	@Test public void test_317() {
		checkNotSubtype("[int]","!int");
	}
	@Test public void test_318() {
		checkNotSubtype("[int]","[[void]]");
	}
	@Test public void test_319() {
		checkNotSubtype("[int]","[[any]]");
	}
	@Test public void test_320() {
		checkNotSubtype("[int]","[[null]]");
	}
	@Test public void test_321() {
		checkNotSubtype("[int]","[[int]]");
	}
	@Test public void test_322() {
		checkNotSubtype("[int]","[!void]");
	}
	@Test public void test_323() {
		checkIsSubtype("[int]","[!any]");
	}
	@Test public void test_324() {
		checkNotSubtype("[int]","[!null]");
	}
	@Test public void test_325() {
		checkNotSubtype("[int]","[!int]");
	}
	@Test public void test_326() {
		checkIsSubtype("[int]","void|void");
	}
	@Test public void test_327() {
		checkNotSubtype("[int]","void|any");
	}
	@Test public void test_328() {
		checkNotSubtype("[int]","void|null");
	}
	@Test public void test_329() {
		checkNotSubtype("[int]","void|int");
	}
	@Test public void test_330() {
		checkNotSubtype("[int]","any|void");
	}
	@Test public void test_331() {
		checkNotSubtype("[int]","any|any");
	}
	@Test public void test_332() {
		checkNotSubtype("[int]","any|null");
	}
	@Test public void test_333() {
		checkNotSubtype("[int]","any|int");
	}
	@Test public void test_334() {
		checkNotSubtype("[int]","null|void");
	}
	@Test public void test_335() {
		checkNotSubtype("[int]","null|any");
	}
	@Test public void test_336() {
		checkNotSubtype("[int]","null|null");
	}
	@Test public void test_337() {
		checkNotSubtype("[int]","null|int");
	}
	@Test public void test_338() {
		checkNotSubtype("[int]","int|void");
	}
	@Test public void test_339() {
		checkNotSubtype("[int]","int|any");
	}
	@Test public void test_340() {
		checkNotSubtype("[int]","int|null");
	}
	@Test public void test_341() {
		checkNotSubtype("[int]","int|int");
	}
	@Test public void test_342() {
		checkIsSubtype("[int]","[void]|void");
	}
	@Test public void test_343() {
		checkNotSubtype("[int]","[any]|any");
	}
	@Test public void test_344() {
		checkNotSubtype("[int]","[null]|null");
	}
	@Test public void test_345() {
		checkNotSubtype("[int]","[int]|int");
	}
	@Test public void test_346() {
		checkNotSubtype("[int]","!void|void");
	}
	@Test public void test_347() {
		checkNotSubtype("[int]","!any|any");
	}
	@Test public void test_348() {
		checkNotSubtype("[int]","!null|null");
	}
	@Test public void test_349() {
		checkNotSubtype("[int]","!int|int");
	}
	@Test public void test_350() {
		checkNotSubtype("[int]","![void]");
	}
	@Test public void test_351() {
		checkNotSubtype("[int]","![any]");
	}
	@Test public void test_352() {
		checkNotSubtype("[int]","![null]");
	}
	@Test public void test_353() {
		checkNotSubtype("[int]","![int]");
	}
	@Test public void test_354() {
		checkIsSubtype("[int]","!!void");
	}
	@Test public void test_355() {
		checkNotSubtype("[int]","!!any");
	}
	@Test public void test_356() {
		checkNotSubtype("[int]","!!null");
	}
	@Test public void test_357() {
		checkNotSubtype("[int]","!!int");
	}
	@Test public void test_358() {
		checkIsSubtype("!void","any");
	}
	@Test public void test_359() {
		checkIsSubtype("!void","null");
	}
	@Test public void test_360() {
		checkIsSubtype("!void","int");
	}
	@Test public void test_361() {
		checkIsSubtype("!void","[void]");
	}
	@Test public void test_362() {
		checkIsSubtype("!void","[any]");
	}
	@Test public void test_363() {
		checkIsSubtype("!void","[null]");
	}
	@Test public void test_364() {
		checkIsSubtype("!void","[int]");
	}
	@Test public void test_365() {
		checkIsSubtype("!void","!void");
	}
	@Test public void test_366() {
		checkIsSubtype("!void","!any");
	}
	@Test public void test_367() {
		checkIsSubtype("!void","!null");
	}
	@Test public void test_368() {
		checkIsSubtype("!void","!int");
	}
	@Test public void test_369() {
		checkIsSubtype("!void","[[void]]");
	}
	@Test public void test_370() {
		checkIsSubtype("!void","[[any]]");
	}
	@Test public void test_371() {
		checkIsSubtype("!void","[[null]]");
	}
	@Test public void test_372() {
		checkIsSubtype("!void","[[int]]");
	}
	@Test public void test_373() {
		checkIsSubtype("!void","[!void]");
	}
	@Test public void test_374() {
		checkIsSubtype("!void","[!any]");
	}
	@Test public void test_375() {
		checkIsSubtype("!void","[!null]");
	}
	@Test public void test_376() {
		checkIsSubtype("!void","[!int]");
	}
	@Test public void test_377() {
		checkIsSubtype("!void","void|void");
	}
	@Test public void test_378() {
		checkIsSubtype("!void","void|any");
	}
	@Test public void test_379() {
		checkIsSubtype("!void","void|null");
	}
	@Test public void test_380() {
		checkIsSubtype("!void","void|int");
	}
	@Test public void test_381() {
		checkIsSubtype("!void","any|void");
	}
	@Test public void test_382() {
		checkIsSubtype("!void","any|any");
	}
	@Test public void test_383() {
		checkIsSubtype("!void","any|null");
	}
	@Test public void test_384() {
		checkIsSubtype("!void","any|int");
	}
	@Test public void test_385() {
		checkIsSubtype("!void","null|void");
	}
	@Test public void test_386() {
		checkIsSubtype("!void","null|any");
	}
	@Test public void test_387() {
		checkIsSubtype("!void","null|null");
	}
	@Test public void test_388() {
		checkIsSubtype("!void","null|int");
	}
	@Test public void test_389() {
		checkIsSubtype("!void","int|void");
	}
	@Test public void test_390() {
		checkIsSubtype("!void","int|any");
	}
	@Test public void test_391() {
		checkIsSubtype("!void","int|null");
	}
	@Test public void test_392() {
		checkIsSubtype("!void","int|int");
	}
	@Test public void test_393() {
		checkIsSubtype("!void","[void]|void");
	}
	@Test public void test_394() {
		checkIsSubtype("!void","[any]|any");
	}
	@Test public void test_395() {
		checkIsSubtype("!void","[null]|null");
	}
	@Test public void test_396() {
		checkIsSubtype("!void","[int]|int");
	}
	@Test public void test_397() {
		checkIsSubtype("!void","!void|void");
	}
	@Test public void test_398() {
		checkIsSubtype("!void","!any|any");
	}
	@Test public void test_399() {
		checkIsSubtype("!void","!null|null");
	}
	@Test public void test_400() {
		checkIsSubtype("!void","!int|int");
	}
	@Test public void test_401() {
		checkIsSubtype("!void","![void]");
	}
	@Test public void test_402() {
		checkIsSubtype("!void","![any]");
	}
	@Test public void test_403() {
		checkIsSubtype("!void","![null]");
	}
	@Test public void test_404() {
		checkIsSubtype("!void","![int]");
	}
	@Test public void test_405() {
		checkIsSubtype("!void","!!void");
	}
	@Test public void test_406() {
		checkIsSubtype("!void","!!any");
	}
	@Test public void test_407() {
		checkIsSubtype("!void","!!null");
	}
	@Test public void test_408() {
		checkIsSubtype("!void","!!int");
	}
	@Test public void test_409() {
		checkNotSubtype("!any","any");
	}
	@Test public void test_410() {
		checkNotSubtype("!any","null");
	}
	@Test public void test_411() {
		checkNotSubtype("!any","int");
	}
	@Test public void test_412() {
		checkNotSubtype("!any","[void]");
	}
	@Test public void test_413() {
		checkNotSubtype("!any","[any]");
	}
	@Test public void test_414() {
		checkNotSubtype("!any","[null]");
	}
	@Test public void test_415() {
		checkNotSubtype("!any","[int]");
	}
	@Test public void test_416() {
		checkNotSubtype("!any","!void");
	}
	@Test public void test_417() {
		checkIsSubtype("!any","!any");
	}
	@Test public void test_418() {
		checkNotSubtype("!any","!null");
	}
	@Test public void test_419() {
		checkNotSubtype("!any","!int");
	}
	@Test public void test_420() {
		checkNotSubtype("!any","[[void]]");
	}
	@Test public void test_421() {
		checkNotSubtype("!any","[[any]]");
	}
	@Test public void test_422() {
		checkNotSubtype("!any","[[null]]");
	}
	@Test public void test_423() {
		checkNotSubtype("!any","[[int]]");
	}
	@Test public void test_424() {
		checkNotSubtype("!any","[!void]");
	}
	@Test public void test_425() {
		checkNotSubtype("!any","[!any]");
	}
	@Test public void test_426() {
		checkNotSubtype("!any","[!null]");
	}
	@Test public void test_427() {
		checkNotSubtype("!any","[!int]");
	}
	@Test public void test_428() {
		checkIsSubtype("!any","void|void");
	}
	@Test public void test_429() {
		checkNotSubtype("!any","void|any");
	}
	@Test public void test_430() {
		checkNotSubtype("!any","void|null");
	}
	@Test public void test_431() {
		checkNotSubtype("!any","void|int");
	}
	@Test public void test_432() {
		checkNotSubtype("!any","any|void");
	}
	@Test public void test_433() {
		checkNotSubtype("!any","any|any");
	}
	@Test public void test_434() {
		checkNotSubtype("!any","any|null");
	}
	@Test public void test_435() {
		checkNotSubtype("!any","any|int");
	}
	@Test public void test_436() {
		checkNotSubtype("!any","null|void");
	}
	@Test public void test_437() {
		checkNotSubtype("!any","null|any");
	}
	@Test public void test_438() {
		checkNotSubtype("!any","null|null");
	}
	@Test public void test_439() {
		checkNotSubtype("!any","null|int");
	}
	@Test public void test_440() {
		checkNotSubtype("!any","int|void");
	}
	@Test public void test_441() {
		checkNotSubtype("!any","int|any");
	}
	@Test public void test_442() {
		checkNotSubtype("!any","int|null");
	}
	@Test public void test_443() {
		checkNotSubtype("!any","int|int");
	}
	@Test public void test_444() {
		checkNotSubtype("!any","[void]|void");
	}
	@Test public void test_445() {
		checkNotSubtype("!any","[any]|any");
	}
	@Test public void test_446() {
		checkNotSubtype("!any","[null]|null");
	}
	@Test public void test_447() {
		checkNotSubtype("!any","[int]|int");
	}
	@Test public void test_448() {
		checkNotSubtype("!any","!void|void");
	}
	@Test public void test_449() {
		checkNotSubtype("!any","!any|any");
	}
	@Test public void test_450() {
		checkNotSubtype("!any","!null|null");
	}
	@Test public void test_451() {
		checkNotSubtype("!any","!int|int");
	}
	@Test public void test_452() {
		checkNotSubtype("!any","![void]");
	}
	@Test public void test_453() {
		checkNotSubtype("!any","![any]");
	}
	@Test public void test_454() {
		checkNotSubtype("!any","![null]");
	}
	@Test public void test_455() {
		checkNotSubtype("!any","![int]");
	}
	@Test public void test_456() {
		checkIsSubtype("!any","!!void");
	}
	@Test public void test_457() {
		checkNotSubtype("!any","!!any");
	}
	@Test public void test_458() {
		checkNotSubtype("!any","!!null");
	}
	@Test public void test_459() {
		checkNotSubtype("!any","!!int");
	}
	@Test public void test_460() {
		checkNotSubtype("!null","any");
	}
	@Test public void test_461() {
		checkNotSubtype("!null","null");
	}
	@Test public void test_462() {
		checkIsSubtype("!null","int");
	}
	@Test public void test_463() {
		checkIsSubtype("!null","[void]");
	}
	@Test public void test_464() {
		checkIsSubtype("!null","[any]");
	}
	@Test public void test_465() {
		checkIsSubtype("!null","[null]");
	}
	@Test public void test_466() {
		checkIsSubtype("!null","[int]");
	}
	@Test public void test_467() {
		checkNotSubtype("!null","!void");
	}
	@Test public void test_468() {
		checkIsSubtype("!null","!any");
	}
	@Test public void test_469() {
		checkIsSubtype("!null","!null");
	}
	@Test public void test_470() {
		checkNotSubtype("!null","!int");
	}
	@Test public void test_471() {
		checkIsSubtype("!null","[[void]]");
	}
	@Test public void test_472() {
		checkIsSubtype("!null","[[any]]");
	}
	@Test public void test_473() {
		checkIsSubtype("!null","[[null]]");
	}
	@Test public void test_474() {
		checkIsSubtype("!null","[[int]]");
	}
	@Test public void test_475() {
		checkIsSubtype("!null","[!void]");
	}
	@Test public void test_476() {
		checkIsSubtype("!null","[!any]");
	}
	@Test public void test_477() {
		checkIsSubtype("!null","[!null]");
	}
	@Test public void test_478() {
		checkIsSubtype("!null","[!int]");
	}
	@Test public void test_479() {
		checkIsSubtype("!null","void|void");
	}
	@Test public void test_480() {
		checkNotSubtype("!null","void|any");
	}
	@Test public void test_481() {
		checkNotSubtype("!null","void|null");
	}
	@Test public void test_482() {
		checkIsSubtype("!null","void|int");
	}
	@Test public void test_483() {
		checkNotSubtype("!null","any|void");
	}
	@Test public void test_484() {
		checkNotSubtype("!null","any|any");
	}
	@Test public void test_485() {
		checkNotSubtype("!null","any|null");
	}
	@Test public void test_486() {
		checkNotSubtype("!null","any|int");
	}
	@Test public void test_487() {
		checkNotSubtype("!null","null|void");
	}
	@Test public void test_488() {
		checkNotSubtype("!null","null|any");
	}
	@Test public void test_489() {
		checkNotSubtype("!null","null|null");
	}
	@Test public void test_490() {
		checkNotSubtype("!null","null|int");
	}
	@Test public void test_491() {
		checkIsSubtype("!null","int|void");
	}
	@Test public void test_492() {
		checkNotSubtype("!null","int|any");
	}
	@Test public void test_493() {
		checkNotSubtype("!null","int|null");
	}
	@Test public void test_494() {
		checkIsSubtype("!null","int|int");
	}
	@Test public void test_495() {
		checkIsSubtype("!null","[void]|void");
	}
	@Test public void test_496() {
		checkNotSubtype("!null","[any]|any");
	}
	@Test public void test_497() {
		checkNotSubtype("!null","[null]|null");
	}
	@Test public void test_498() {
		checkIsSubtype("!null","[int]|int");
	}
	@Test public void test_499() {
		checkNotSubtype("!null","!void|void");
	}
	@Test public void test_500() {
		checkNotSubtype("!null","!any|any");
	}
	@Test public void test_501() {
		checkNotSubtype("!null","!null|null");
	}
	@Test public void test_502() {
		checkNotSubtype("!null","!int|int");
	}
	@Test public void test_503() {
		checkNotSubtype("!null","![void]");
	}
	@Test public void test_504() {
		checkNotSubtype("!null","![any]");
	}
	@Test public void test_505() {
		checkNotSubtype("!null","![null]");
	}
	@Test public void test_506() {
		checkNotSubtype("!null","![int]");
	}
	@Test public void test_507() {
		checkIsSubtype("!null","!!void");
	}
	@Test public void test_508() {
		checkNotSubtype("!null","!!any");
	}
	@Test public void test_509() {
		checkNotSubtype("!null","!!null");
	}
	@Test public void test_510() {
		checkIsSubtype("!null","!!int");
	}
	@Test public void test_511() {
		checkNotSubtype("!int","any");
	}
	@Test public void test_512() {
		checkIsSubtype("!int","null");
	}
	@Test public void test_513() {
		checkNotSubtype("!int","int");
	}
	@Test public void test_514() {
		checkIsSubtype("!int","[void]");
	}
	@Test public void test_515() {
		checkIsSubtype("!int","[any]");
	}
	@Test public void test_516() {
		checkIsSubtype("!int","[null]");
	}
	@Test public void test_517() {
		checkIsSubtype("!int","[int]");
	}
	@Test public void test_518() {
		checkNotSubtype("!int","!void");
	}
	@Test public void test_519() {
		checkIsSubtype("!int","!any");
	}
	@Test public void test_520() {
		checkNotSubtype("!int","!null");
	}
	@Test public void test_521() {
		checkIsSubtype("!int","!int");
	}
	@Test public void test_522() {
		checkIsSubtype("!int","[[void]]");
	}
	@Test public void test_523() {
		checkIsSubtype("!int","[[any]]");
	}
	@Test public void test_524() {
		checkIsSubtype("!int","[[null]]");
	}
	@Test public void test_525() {
		checkIsSubtype("!int","[[int]]");
	}
	@Test public void test_526() {
		checkIsSubtype("!int","[!void]");
	}
	@Test public void test_527() {
		checkIsSubtype("!int","[!any]");
	}
	@Test public void test_528() {
		checkIsSubtype("!int","[!null]");
	}
	@Test public void test_529() {
		checkIsSubtype("!int","[!int]");
	}
	@Test public void test_530() {
		checkIsSubtype("!int","void|void");
	}
	@Test public void test_531() {
		checkNotSubtype("!int","void|any");
	}
	@Test public void test_532() {
		checkIsSubtype("!int","void|null");
	}
	@Test public void test_533() {
		checkNotSubtype("!int","void|int");
	}
	@Test public void test_534() {
		checkNotSubtype("!int","any|void");
	}
	@Test public void test_535() {
		checkNotSubtype("!int","any|any");
	}
	@Test public void test_536() {
		checkNotSubtype("!int","any|null");
	}
	@Test public void test_537() {
		checkNotSubtype("!int","any|int");
	}
	@Test public void test_538() {
		checkIsSubtype("!int","null|void");
	}
	@Test public void test_539() {
		checkNotSubtype("!int","null|any");
	}
	@Test public void test_540() {
		checkIsSubtype("!int","null|null");
	}
	@Test public void test_541() {
		checkNotSubtype("!int","null|int");
	}
	@Test public void test_542() {
		checkNotSubtype("!int","int|void");
	}
	@Test public void test_543() {
		checkNotSubtype("!int","int|any");
	}
	@Test public void test_544() {
		checkNotSubtype("!int","int|null");
	}
	@Test public void test_545() {
		checkNotSubtype("!int","int|int");
	}
	@Test public void test_546() {
		checkIsSubtype("!int","[void]|void");
	}
	@Test public void test_547() {
		checkNotSubtype("!int","[any]|any");
	}
	@Test public void test_548() {
		checkIsSubtype("!int","[null]|null");
	}
	@Test public void test_549() {
		checkNotSubtype("!int","[int]|int");
	}
	@Test public void test_550() {
		checkNotSubtype("!int","!void|void");
	}
	@Test public void test_551() {
		checkNotSubtype("!int","!any|any");
	}
	@Test public void test_552() {
		checkNotSubtype("!int","!null|null");
	}
	@Test public void test_553() {
		checkNotSubtype("!int","!int|int");
	}
	@Test public void test_554() {
		checkNotSubtype("!int","![void]");
	}
	@Test public void test_555() {
		checkNotSubtype("!int","![any]");
	}
	@Test public void test_556() {
		checkNotSubtype("!int","![null]");
	}
	@Test public void test_557() {
		checkNotSubtype("!int","![int]");
	}
	@Test public void test_558() {
		checkIsSubtype("!int","!!void");
	}
	@Test public void test_559() {
		checkNotSubtype("!int","!!any");
	}
	@Test public void test_560() {
		checkIsSubtype("!int","!!null");
	}
	@Test public void test_561() {
		checkNotSubtype("!int","!!int");
	}
	@Test public void test_562() {
		checkNotSubtype("[[void]]","any");
	}
	@Test public void test_563() {
		checkNotSubtype("[[void]]","null");
	}
	@Test public void test_564() {
		checkNotSubtype("[[void]]","int");
	}
	@Test public void test_565() {
		checkIsSubtype("[[void]]","[void]");
	}
	@Test public void test_566() {
		checkNotSubtype("[[void]]","[any]");
	}
	@Test public void test_567() {
		checkNotSubtype("[[void]]","[null]");
	}
	@Test public void test_568() {
		checkNotSubtype("[[void]]","[int]");
	}
	@Test public void test_569() {
		checkNotSubtype("[[void]]","!void");
	}
	@Test public void test_570() {
		checkIsSubtype("[[void]]","!any");
	}
	@Test public void test_571() {
		checkNotSubtype("[[void]]","!null");
	}
	@Test public void test_572() {
		checkNotSubtype("[[void]]","!int");
	}
	@Test public void test_573() {
		checkIsSubtype("[[void]]","[[void]]");
	}
	@Test public void test_574() {
		checkNotSubtype("[[void]]","[[any]]");
	}
	@Test public void test_575() {
		checkNotSubtype("[[void]]","[[null]]");
	}
	@Test public void test_576() {
		checkNotSubtype("[[void]]","[[int]]");
	}
	@Test public void test_577() {
		checkNotSubtype("[[void]]","[!void]");
	}
	@Test public void test_578() {
		checkIsSubtype("[[void]]","[!any]");
	}
	@Test public void test_579() {
		checkNotSubtype("[[void]]","[!null]");
	}
	@Test public void test_580() {
		checkNotSubtype("[[void]]","[!int]");
	}
	@Test public void test_581() {
		checkIsSubtype("[[void]]","void|void");
	}
	@Test public void test_582() {
		checkNotSubtype("[[void]]","void|any");
	}
	@Test public void test_583() {
		checkNotSubtype("[[void]]","void|null");
	}
	@Test public void test_584() {
		checkNotSubtype("[[void]]","void|int");
	}
	@Test public void test_585() {
		checkNotSubtype("[[void]]","any|void");
	}
	@Test public void test_586() {
		checkNotSubtype("[[void]]","any|any");
	}
	@Test public void test_587() {
		checkNotSubtype("[[void]]","any|null");
	}
	@Test public void test_588() {
		checkNotSubtype("[[void]]","any|int");
	}
	@Test public void test_589() {
		checkNotSubtype("[[void]]","null|void");
	}
	@Test public void test_590() {
		checkNotSubtype("[[void]]","null|any");
	}
	@Test public void test_591() {
		checkNotSubtype("[[void]]","null|null");
	}
	@Test public void test_592() {
		checkNotSubtype("[[void]]","null|int");
	}
	@Test public void test_593() {
		checkNotSubtype("[[void]]","int|void");
	}
	@Test public void test_594() {
		checkNotSubtype("[[void]]","int|any");
	}
	@Test public void test_595() {
		checkNotSubtype("[[void]]","int|null");
	}
	@Test public void test_596() {
		checkNotSubtype("[[void]]","int|int");
	}
	@Test public void test_597() {
		checkIsSubtype("[[void]]","[void]|void");
	}
	@Test public void test_598() {
		checkNotSubtype("[[void]]","[any]|any");
	}
	@Test public void test_599() {
		checkNotSubtype("[[void]]","[null]|null");
	}
	@Test public void test_600() {
		checkNotSubtype("[[void]]","[int]|int");
	}
	@Test public void test_601() {
		checkNotSubtype("[[void]]","!void|void");
	}
	@Test public void test_602() {
		checkNotSubtype("[[void]]","!any|any");
	}
	@Test public void test_603() {
		checkNotSubtype("[[void]]","!null|null");
	}
	@Test public void test_604() {
		checkNotSubtype("[[void]]","!int|int");
	}
	@Test public void test_605() {
		checkNotSubtype("[[void]]","![void]");
	}
	@Test public void test_606() {
		checkNotSubtype("[[void]]","![any]");
	}
	@Test public void test_607() {
		checkNotSubtype("[[void]]","![null]");
	}
	@Test public void test_608() {
		checkNotSubtype("[[void]]","![int]");
	}
	@Test public void test_609() {
		checkIsSubtype("[[void]]","!!void");
	}
	@Test public void test_610() {
		checkNotSubtype("[[void]]","!!any");
	}
	@Test public void test_611() {
		checkNotSubtype("[[void]]","!!null");
	}
	@Test public void test_612() {
		checkNotSubtype("[[void]]","!!int");
	}
	@Test public void test_613() {
		checkNotSubtype("[[any]]","any");
	}
	@Test public void test_614() {
		checkNotSubtype("[[any]]","null");
	}
	@Test public void test_615() {
		checkNotSubtype("[[any]]","int");
	}
	@Test public void test_616() {
		checkIsSubtype("[[any]]","[void]");
	}
	@Test public void test_617() {
		checkNotSubtype("[[any]]","[any]");
	}
	@Test public void test_618() {
		checkNotSubtype("[[any]]","[null]");
	}
	@Test public void test_619() {
		checkNotSubtype("[[any]]","[int]");
	}
	@Test public void test_620() {
		checkNotSubtype("[[any]]","!void");
	}
	@Test public void test_621() {
		checkIsSubtype("[[any]]","!any");
	}
	@Test public void test_622() {
		checkNotSubtype("[[any]]","!null");
	}
	@Test public void test_623() {
		checkNotSubtype("[[any]]","!int");
	}
	@Test public void test_624() {
		checkIsSubtype("[[any]]","[[void]]");
	}
	@Test public void test_625() {
		checkIsSubtype("[[any]]","[[any]]");
	}
	@Test public void test_626() {
		checkIsSubtype("[[any]]","[[null]]");
	}
	@Test public void test_627() {
		checkIsSubtype("[[any]]","[[int]]");
	}
	@Test public void test_628() {
		checkNotSubtype("[[any]]","[!void]");
	}
	@Test public void test_629() {
		checkIsSubtype("[[any]]","[!any]");
	}
	@Test public void test_630() {
		checkNotSubtype("[[any]]","[!null]");
	}
	@Test public void test_631() {
		checkNotSubtype("[[any]]","[!int]");
	}
	@Test public void test_632() {
		checkIsSubtype("[[any]]","void|void");
	}
	@Test public void test_633() {
		checkNotSubtype("[[any]]","void|any");
	}
	@Test public void test_634() {
		checkNotSubtype("[[any]]","void|null");
	}
	@Test public void test_635() {
		checkNotSubtype("[[any]]","void|int");
	}
	@Test public void test_636() {
		checkNotSubtype("[[any]]","any|void");
	}
	@Test public void test_637() {
		checkNotSubtype("[[any]]","any|any");
	}
	@Test public void test_638() {
		checkNotSubtype("[[any]]","any|null");
	}
	@Test public void test_639() {
		checkNotSubtype("[[any]]","any|int");
	}
	@Test public void test_640() {
		checkNotSubtype("[[any]]","null|void");
	}
	@Test public void test_641() {
		checkNotSubtype("[[any]]","null|any");
	}
	@Test public void test_642() {
		checkNotSubtype("[[any]]","null|null");
	}
	@Test public void test_643() {
		checkNotSubtype("[[any]]","null|int");
	}
	@Test public void test_644() {
		checkNotSubtype("[[any]]","int|void");
	}
	@Test public void test_645() {
		checkNotSubtype("[[any]]","int|any");
	}
	@Test public void test_646() {
		checkNotSubtype("[[any]]","int|null");
	}
	@Test public void test_647() {
		checkNotSubtype("[[any]]","int|int");
	}
	@Test public void test_648() {
		checkIsSubtype("[[any]]","[void]|void");
	}
	@Test public void test_649() {
		checkNotSubtype("[[any]]","[any]|any");
	}
	@Test public void test_650() {
		checkNotSubtype("[[any]]","[null]|null");
	}
	@Test public void test_651() {
		checkNotSubtype("[[any]]","[int]|int");
	}
	@Test public void test_652() {
		checkNotSubtype("[[any]]","!void|void");
	}
	@Test public void test_653() {
		checkNotSubtype("[[any]]","!any|any");
	}
	@Test public void test_654() {
		checkNotSubtype("[[any]]","!null|null");
	}
	@Test public void test_655() {
		checkNotSubtype("[[any]]","!int|int");
	}
	@Test public void test_656() {
		checkNotSubtype("[[any]]","![void]");
	}
	@Test public void test_657() {
		checkNotSubtype("[[any]]","![any]");
	}
	@Test public void test_658() {
		checkNotSubtype("[[any]]","![null]");
	}
	@Test public void test_659() {
		checkNotSubtype("[[any]]","![int]");
	}
	@Test public void test_660() {
		checkIsSubtype("[[any]]","!!void");
	}
	@Test public void test_661() {
		checkNotSubtype("[[any]]","!!any");
	}
	@Test public void test_662() {
		checkNotSubtype("[[any]]","!!null");
	}
	@Test public void test_663() {
		checkNotSubtype("[[any]]","!!int");
	}
	@Test public void test_664() {
		checkNotSubtype("[[null]]","any");
	}
	@Test public void test_665() {
		checkNotSubtype("[[null]]","null");
	}
	@Test public void test_666() {
		checkNotSubtype("[[null]]","int");
	}
	@Test public void test_667() {
		checkIsSubtype("[[null]]","[void]");
	}
	@Test public void test_668() {
		checkNotSubtype("[[null]]","[any]");
	}
	@Test public void test_669() {
		checkNotSubtype("[[null]]","[null]");
	}
	@Test public void test_670() {
		checkNotSubtype("[[null]]","[int]");
	}
	@Test public void test_671() {
		checkNotSubtype("[[null]]","!void");
	}
	@Test public void test_672() {
		checkIsSubtype("[[null]]","!any");
	}
	@Test public void test_673() {
		checkNotSubtype("[[null]]","!null");
	}
	@Test public void test_674() {
		checkNotSubtype("[[null]]","!int");
	}
	@Test public void test_675() {
		checkIsSubtype("[[null]]","[[void]]");
	}
	@Test public void test_676() {
		checkNotSubtype("[[null]]","[[any]]");
	}
	@Test public void test_677() {
		checkIsSubtype("[[null]]","[[null]]");
	}
	@Test public void test_678() {
		checkNotSubtype("[[null]]","[[int]]");
	}
	@Test public void test_679() {
		checkNotSubtype("[[null]]","[!void]");
	}
	@Test public void test_680() {
		checkIsSubtype("[[null]]","[!any]");
	}
	@Test public void test_681() {
		checkNotSubtype("[[null]]","[!null]");
	}
	@Test public void test_682() {
		checkNotSubtype("[[null]]","[!int]");
	}
	@Test public void test_683() {
		checkIsSubtype("[[null]]","void|void");
	}
	@Test public void test_684() {
		checkNotSubtype("[[null]]","void|any");
	}
	@Test public void test_685() {
		checkNotSubtype("[[null]]","void|null");
	}
	@Test public void test_686() {
		checkNotSubtype("[[null]]","void|int");
	}
	@Test public void test_687() {
		checkNotSubtype("[[null]]","any|void");
	}
	@Test public void test_688() {
		checkNotSubtype("[[null]]","any|any");
	}
	@Test public void test_689() {
		checkNotSubtype("[[null]]","any|null");
	}
	@Test public void test_690() {
		checkNotSubtype("[[null]]","any|int");
	}
	@Test public void test_691() {
		checkNotSubtype("[[null]]","null|void");
	}
	@Test public void test_692() {
		checkNotSubtype("[[null]]","null|any");
	}
	@Test public void test_693() {
		checkNotSubtype("[[null]]","null|null");
	}
	@Test public void test_694() {
		checkNotSubtype("[[null]]","null|int");
	}
	@Test public void test_695() {
		checkNotSubtype("[[null]]","int|void");
	}
	@Test public void test_696() {
		checkNotSubtype("[[null]]","int|any");
	}
	@Test public void test_697() {
		checkNotSubtype("[[null]]","int|null");
	}
	@Test public void test_698() {
		checkNotSubtype("[[null]]","int|int");
	}
	@Test public void test_699() {
		checkIsSubtype("[[null]]","[void]|void");
	}
	@Test public void test_700() {
		checkNotSubtype("[[null]]","[any]|any");
	}
	@Test public void test_701() {
		checkNotSubtype("[[null]]","[null]|null");
	}
	@Test public void test_702() {
		checkNotSubtype("[[null]]","[int]|int");
	}
	@Test public void test_703() {
		checkNotSubtype("[[null]]","!void|void");
	}
	@Test public void test_704() {
		checkNotSubtype("[[null]]","!any|any");
	}
	@Test public void test_705() {
		checkNotSubtype("[[null]]","!null|null");
	}
	@Test public void test_706() {
		checkNotSubtype("[[null]]","!int|int");
	}
	@Test public void test_707() {
		checkNotSubtype("[[null]]","![void]");
	}
	@Test public void test_708() {
		checkNotSubtype("[[null]]","![any]");
	}
	@Test public void test_709() {
		checkNotSubtype("[[null]]","![null]");
	}
	@Test public void test_710() {
		checkNotSubtype("[[null]]","![int]");
	}
	@Test public void test_711() {
		checkIsSubtype("[[null]]","!!void");
	}
	@Test public void test_712() {
		checkNotSubtype("[[null]]","!!any");
	}
	@Test public void test_713() {
		checkNotSubtype("[[null]]","!!null");
	}
	@Test public void test_714() {
		checkNotSubtype("[[null]]","!!int");
	}
	@Test public void test_715() {
		checkNotSubtype("[[int]]","any");
	}
	@Test public void test_716() {
		checkNotSubtype("[[int]]","null");
	}
	@Test public void test_717() {
		checkNotSubtype("[[int]]","int");
	}
	@Test public void test_718() {
		checkIsSubtype("[[int]]","[void]");
	}
	@Test public void test_719() {
		checkNotSubtype("[[int]]","[any]");
	}
	@Test public void test_720() {
		checkNotSubtype("[[int]]","[null]");
	}
	@Test public void test_721() {
		checkNotSubtype("[[int]]","[int]");
	}
	@Test public void test_722() {
		checkNotSubtype("[[int]]","!void");
	}
	@Test public void test_723() {
		checkIsSubtype("[[int]]","!any");
	}
	@Test public void test_724() {
		checkNotSubtype("[[int]]","!null");
	}
	@Test public void test_725() {
		checkNotSubtype("[[int]]","!int");
	}
	@Test public void test_726() {
		checkIsSubtype("[[int]]","[[void]]");
	}
	@Test public void test_727() {
		checkNotSubtype("[[int]]","[[any]]");
	}
	@Test public void test_728() {
		checkNotSubtype("[[int]]","[[null]]");
	}
	@Test public void test_729() {
		checkIsSubtype("[[int]]","[[int]]");
	}
	@Test public void test_730() {
		checkNotSubtype("[[int]]","[!void]");
	}
	@Test public void test_731() {
		checkIsSubtype("[[int]]","[!any]");
	}
	@Test public void test_732() {
		checkNotSubtype("[[int]]","[!null]");
	}
	@Test public void test_733() {
		checkNotSubtype("[[int]]","[!int]");
	}
	@Test public void test_734() {
		checkIsSubtype("[[int]]","void|void");
	}
	@Test public void test_735() {
		checkNotSubtype("[[int]]","void|any");
	}
	@Test public void test_736() {
		checkNotSubtype("[[int]]","void|null");
	}
	@Test public void test_737() {
		checkNotSubtype("[[int]]","void|int");
	}
	@Test public void test_738() {
		checkNotSubtype("[[int]]","any|void");
	}
	@Test public void test_739() {
		checkNotSubtype("[[int]]","any|any");
	}
	@Test public void test_740() {
		checkNotSubtype("[[int]]","any|null");
	}
	@Test public void test_741() {
		checkNotSubtype("[[int]]","any|int");
	}
	@Test public void test_742() {
		checkNotSubtype("[[int]]","null|void");
	}
	@Test public void test_743() {
		checkNotSubtype("[[int]]","null|any");
	}
	@Test public void test_744() {
		checkNotSubtype("[[int]]","null|null");
	}
	@Test public void test_745() {
		checkNotSubtype("[[int]]","null|int");
	}
	@Test public void test_746() {
		checkNotSubtype("[[int]]","int|void");
	}
	@Test public void test_747() {
		checkNotSubtype("[[int]]","int|any");
	}
	@Test public void test_748() {
		checkNotSubtype("[[int]]","int|null");
	}
	@Test public void test_749() {
		checkNotSubtype("[[int]]","int|int");
	}
	@Test public void test_750() {
		checkIsSubtype("[[int]]","[void]|void");
	}
	@Test public void test_751() {
		checkNotSubtype("[[int]]","[any]|any");
	}
	@Test public void test_752() {
		checkNotSubtype("[[int]]","[null]|null");
	}
	@Test public void test_753() {
		checkNotSubtype("[[int]]","[int]|int");
	}
	@Test public void test_754() {
		checkNotSubtype("[[int]]","!void|void");
	}
	@Test public void test_755() {
		checkNotSubtype("[[int]]","!any|any");
	}
	@Test public void test_756() {
		checkNotSubtype("[[int]]","!null|null");
	}
	@Test public void test_757() {
		checkNotSubtype("[[int]]","!int|int");
	}
	@Test public void test_758() {
		checkNotSubtype("[[int]]","![void]");
	}
	@Test public void test_759() {
		checkNotSubtype("[[int]]","![any]");
	}
	@Test public void test_760() {
		checkNotSubtype("[[int]]","![null]");
	}
	@Test public void test_761() {
		checkNotSubtype("[[int]]","![int]");
	}
	@Test public void test_762() {
		checkIsSubtype("[[int]]","!!void");
	}
	@Test public void test_763() {
		checkNotSubtype("[[int]]","!!any");
	}
	@Test public void test_764() {
		checkNotSubtype("[[int]]","!!null");
	}
	@Test public void test_765() {
		checkNotSubtype("[[int]]","!!int");
	}
	@Test public void test_766() {
		checkNotSubtype("[!void]","any");
	}
	@Test public void test_767() {
		checkNotSubtype("[!void]","null");
	}
	@Test public void test_768() {
		checkNotSubtype("[!void]","int");
	}
	@Test public void test_769() {
		checkIsSubtype("[!void]","[void]");
	}
	@Test public void test_770() {
		checkIsSubtype("[!void]","[any]");
	}
	@Test public void test_771() {
		checkIsSubtype("[!void]","[null]");
	}
	@Test public void test_772() {
		checkIsSubtype("[!void]","[int]");
	}
	@Test public void test_773() {
		checkNotSubtype("[!void]","!void");
	}
	@Test public void test_774() {
		checkIsSubtype("[!void]","!any");
	}
	@Test public void test_775() {
		checkNotSubtype("[!void]","!null");
	}
	@Test public void test_776() {
		checkNotSubtype("[!void]","!int");
	}
	@Test public void test_777() {
		checkIsSubtype("[!void]","[[void]]");
	}
	@Test public void test_778() {
		checkIsSubtype("[!void]","[[any]]");
	}
	@Test public void test_779() {
		checkIsSubtype("[!void]","[[null]]");
	}
	@Test public void test_780() {
		checkIsSubtype("[!void]","[[int]]");
	}
	@Test public void test_781() {
		checkIsSubtype("[!void]","[!void]");
	}
	@Test public void test_782() {
		checkIsSubtype("[!void]","[!any]");
	}
	@Test public void test_783() {
		checkIsSubtype("[!void]","[!null]");
	}
	@Test public void test_784() {
		checkIsSubtype("[!void]","[!int]");
	}
	@Test public void test_785() {
		checkIsSubtype("[!void]","void|void");
	}
	@Test public void test_786() {
		checkNotSubtype("[!void]","void|any");
	}
	@Test public void test_787() {
		checkNotSubtype("[!void]","void|null");
	}
	@Test public void test_788() {
		checkNotSubtype("[!void]","void|int");
	}
	@Test public void test_789() {
		checkNotSubtype("[!void]","any|void");
	}
	@Test public void test_790() {
		checkNotSubtype("[!void]","any|any");
	}
	@Test public void test_791() {
		checkNotSubtype("[!void]","any|null");
	}
	@Test public void test_792() {
		checkNotSubtype("[!void]","any|int");
	}
	@Test public void test_793() {
		checkNotSubtype("[!void]","null|void");
	}
	@Test public void test_794() {
		checkNotSubtype("[!void]","null|any");
	}
	@Test public void test_795() {
		checkNotSubtype("[!void]","null|null");
	}
	@Test public void test_796() {
		checkNotSubtype("[!void]","null|int");
	}
	@Test public void test_797() {
		checkNotSubtype("[!void]","int|void");
	}
	@Test public void test_798() {
		checkNotSubtype("[!void]","int|any");
	}
	@Test public void test_799() {
		checkNotSubtype("[!void]","int|null");
	}
	@Test public void test_800() {
		checkNotSubtype("[!void]","int|int");
	}
	@Test public void test_801() {
		checkIsSubtype("[!void]","[void]|void");
	}
	@Test public void test_802() {
		checkNotSubtype("[!void]","[any]|any");
	}
	@Test public void test_803() {
		checkNotSubtype("[!void]","[null]|null");
	}
	@Test public void test_804() {
		checkNotSubtype("[!void]","[int]|int");
	}
	@Test public void test_805() {
		checkNotSubtype("[!void]","!void|void");
	}
	@Test public void test_806() {
		checkNotSubtype("[!void]","!any|any");
	}
	@Test public void test_807() {
		checkNotSubtype("[!void]","!null|null");
	}
	@Test public void test_808() {
		checkNotSubtype("[!void]","!int|int");
	}
	@Test public void test_809() {
		checkNotSubtype("[!void]","![void]");
	}
	@Test public void test_810() {
		checkNotSubtype("[!void]","![any]");
	}
	@Test public void test_811() {
		checkNotSubtype("[!void]","![null]");
	}
	@Test public void test_812() {
		checkNotSubtype("[!void]","![int]");
	}
	@Test public void test_813() {
		checkIsSubtype("[!void]","!!void");
	}
	@Test public void test_814() {
		checkNotSubtype("[!void]","!!any");
	}
	@Test public void test_815() {
		checkNotSubtype("[!void]","!!null");
	}
	@Test public void test_816() {
		checkNotSubtype("[!void]","!!int");
	}
	@Test public void test_817() {
		checkNotSubtype("[!any]","any");
	}
	@Test public void test_818() {
		checkNotSubtype("[!any]","null");
	}
	@Test public void test_819() {
		checkNotSubtype("[!any]","int");
	}
	@Test public void test_820() {
		checkIsSubtype("[!any]","[void]");
	}
	@Test public void test_821() {
		checkNotSubtype("[!any]","[any]");
	}
	@Test public void test_822() {
		checkNotSubtype("[!any]","[null]");
	}
	@Test public void test_823() {
		checkNotSubtype("[!any]","[int]");
	}
	@Test public void test_824() {
		checkNotSubtype("[!any]","!void");
	}
	@Test public void test_825() {
		checkIsSubtype("[!any]","!any");
	}
	@Test public void test_826() {
		checkNotSubtype("[!any]","!null");
	}
	@Test public void test_827() {
		checkNotSubtype("[!any]","!int");
	}
	@Test public void test_828() {
		checkNotSubtype("[!any]","[[void]]");
	}
	@Test public void test_829() {
		checkNotSubtype("[!any]","[[any]]");
	}
	@Test public void test_830() {
		checkNotSubtype("[!any]","[[null]]");
	}
	@Test public void test_831() {
		checkNotSubtype("[!any]","[[int]]");
	}
	@Test public void test_832() {
		checkNotSubtype("[!any]","[!void]");
	}
	@Test public void test_833() {
		checkIsSubtype("[!any]","[!any]");
	}
	@Test public void test_834() {
		checkNotSubtype("[!any]","[!null]");
	}
	@Test public void test_835() {
		checkNotSubtype("[!any]","[!int]");
	}
	@Test public void test_836() {
		checkIsSubtype("[!any]","void|void");
	}
	@Test public void test_837() {
		checkNotSubtype("[!any]","void|any");
	}
	@Test public void test_838() {
		checkNotSubtype("[!any]","void|null");
	}
	@Test public void test_839() {
		checkNotSubtype("[!any]","void|int");
	}
	@Test public void test_840() {
		checkNotSubtype("[!any]","any|void");
	}
	@Test public void test_841() {
		checkNotSubtype("[!any]","any|any");
	}
	@Test public void test_842() {
		checkNotSubtype("[!any]","any|null");
	}
	@Test public void test_843() {
		checkNotSubtype("[!any]","any|int");
	}
	@Test public void test_844() {
		checkNotSubtype("[!any]","null|void");
	}
	@Test public void test_845() {
		checkNotSubtype("[!any]","null|any");
	}
	@Test public void test_846() {
		checkNotSubtype("[!any]","null|null");
	}
	@Test public void test_847() {
		checkNotSubtype("[!any]","null|int");
	}
	@Test public void test_848() {
		checkNotSubtype("[!any]","int|void");
	}
	@Test public void test_849() {
		checkNotSubtype("[!any]","int|any");
	}
	@Test public void test_850() {
		checkNotSubtype("[!any]","int|null");
	}
	@Test public void test_851() {
		checkNotSubtype("[!any]","int|int");
	}
	@Test public void test_852() {
		checkIsSubtype("[!any]","[void]|void");
	}
	@Test public void test_853() {
		checkNotSubtype("[!any]","[any]|any");
	}
	@Test public void test_854() {
		checkNotSubtype("[!any]","[null]|null");
	}
	@Test public void test_855() {
		checkNotSubtype("[!any]","[int]|int");
	}
	@Test public void test_856() {
		checkNotSubtype("[!any]","!void|void");
	}
	@Test public void test_857() {
		checkNotSubtype("[!any]","!any|any");
	}
	@Test public void test_858() {
		checkNotSubtype("[!any]","!null|null");
	}
	@Test public void test_859() {
		checkNotSubtype("[!any]","!int|int");
	}
	@Test public void test_860() {
		checkNotSubtype("[!any]","![void]");
	}
	@Test public void test_861() {
		checkNotSubtype("[!any]","![any]");
	}
	@Test public void test_862() {
		checkNotSubtype("[!any]","![null]");
	}
	@Test public void test_863() {
		checkNotSubtype("[!any]","![int]");
	}
	@Test public void test_864() {
		checkIsSubtype("[!any]","!!void");
	}
	@Test public void test_865() {
		checkNotSubtype("[!any]","!!any");
	}
	@Test public void test_866() {
		checkNotSubtype("[!any]","!!null");
	}
	@Test public void test_867() {
		checkNotSubtype("[!any]","!!int");
	}
	@Test public void test_868() {
		checkNotSubtype("[!null]","any");
	}
	@Test public void test_869() {
		checkNotSubtype("[!null]","null");
	}
	@Test public void test_870() {
		checkNotSubtype("[!null]","int");
	}
	@Test public void test_871() {
		checkIsSubtype("[!null]","[void]");
	}
	@Test public void test_872() {
		checkNotSubtype("[!null]","[any]");
	}
	@Test public void test_873() {
		checkNotSubtype("[!null]","[null]");
	}
	@Test public void test_874() {
		checkIsSubtype("[!null]","[int]");
	}
	@Test public void test_875() {
		checkNotSubtype("[!null]","!void");
	}
	@Test public void test_876() {
		checkIsSubtype("[!null]","!any");
	}
	@Test public void test_877() {
		checkNotSubtype("[!null]","!null");
	}
	@Test public void test_878() {
		checkNotSubtype("[!null]","!int");
	}
	@Test public void test_879() {
		checkIsSubtype("[!null]","[[void]]");
	}
	@Test public void test_880() {
		checkIsSubtype("[!null]","[[any]]");
	}
	@Test public void test_881() {
		checkIsSubtype("[!null]","[[null]]");
	}
	@Test public void test_882() {
		checkIsSubtype("[!null]","[[int]]");
	}
	@Test public void test_883() {
		checkNotSubtype("[!null]","[!void]");
	}
	@Test public void test_884() {
		checkIsSubtype("[!null]","[!any]");
	}
	@Test public void test_885() {
		checkIsSubtype("[!null]","[!null]");
	}
	@Test public void test_886() {
		checkNotSubtype("[!null]","[!int]");
	}
	@Test public void test_887() {
		checkIsSubtype("[!null]","void|void");
	}
	@Test public void test_888() {
		checkNotSubtype("[!null]","void|any");
	}
	@Test public void test_889() {
		checkNotSubtype("[!null]","void|null");
	}
	@Test public void test_890() {
		checkNotSubtype("[!null]","void|int");
	}
	@Test public void test_891() {
		checkNotSubtype("[!null]","any|void");
	}
	@Test public void test_892() {
		checkNotSubtype("[!null]","any|any");
	}
	@Test public void test_893() {
		checkNotSubtype("[!null]","any|null");
	}
	@Test public void test_894() {
		checkNotSubtype("[!null]","any|int");
	}
	@Test public void test_895() {
		checkNotSubtype("[!null]","null|void");
	}
	@Test public void test_896() {
		checkNotSubtype("[!null]","null|any");
	}
	@Test public void test_897() {
		checkNotSubtype("[!null]","null|null");
	}
	@Test public void test_898() {
		checkNotSubtype("[!null]","null|int");
	}
	@Test public void test_899() {
		checkNotSubtype("[!null]","int|void");
	}
	@Test public void test_900() {
		checkNotSubtype("[!null]","int|any");
	}
	@Test public void test_901() {
		checkNotSubtype("[!null]","int|null");
	}
	@Test public void test_902() {
		checkNotSubtype("[!null]","int|int");
	}
	@Test public void test_903() {
		checkIsSubtype("[!null]","[void]|void");
	}
	@Test public void test_904() {
		checkNotSubtype("[!null]","[any]|any");
	}
	@Test public void test_905() {
		checkNotSubtype("[!null]","[null]|null");
	}
	@Test public void test_906() {
		checkNotSubtype("[!null]","[int]|int");
	}
	@Test public void test_907() {
		checkNotSubtype("[!null]","!void|void");
	}
	@Test public void test_908() {
		checkNotSubtype("[!null]","!any|any");
	}
	@Test public void test_909() {
		checkNotSubtype("[!null]","!null|null");
	}
	@Test public void test_910() {
		checkNotSubtype("[!null]","!int|int");
	}
	@Test public void test_911() {
		checkNotSubtype("[!null]","![void]");
	}
	@Test public void test_912() {
		checkNotSubtype("[!null]","![any]");
	}
	@Test public void test_913() {
		checkNotSubtype("[!null]","![null]");
	}
	@Test public void test_914() {
		checkNotSubtype("[!null]","![int]");
	}
	@Test public void test_915() {
		checkIsSubtype("[!null]","!!void");
	}
	@Test public void test_916() {
		checkNotSubtype("[!null]","!!any");
	}
	@Test public void test_917() {
		checkNotSubtype("[!null]","!!null");
	}
	@Test public void test_918() {
		checkNotSubtype("[!null]","!!int");
	}
	@Test public void test_919() {
		checkNotSubtype("[!int]","any");
	}
	@Test public void test_920() {
		checkNotSubtype("[!int]","null");
	}
	@Test public void test_921() {
		checkNotSubtype("[!int]","int");
	}
	@Test public void test_922() {
		checkIsSubtype("[!int]","[void]");
	}
	@Test public void test_923() {
		checkNotSubtype("[!int]","[any]");
	}
	@Test public void test_924() {
		checkIsSubtype("[!int]","[null]");
	}
	@Test public void test_925() {
		checkNotSubtype("[!int]","[int]");
	}
	@Test public void test_926() {
		checkNotSubtype("[!int]","!void");
	}
	@Test public void test_927() {
		checkIsSubtype("[!int]","!any");
	}
	@Test public void test_928() {
		checkNotSubtype("[!int]","!null");
	}
	@Test public void test_929() {
		checkNotSubtype("[!int]","!int");
	}
	@Test public void test_930() {
		checkIsSubtype("[!int]","[[void]]");
	}
	@Test public void test_931() {
		checkIsSubtype("[!int]","[[any]]");
	}
	@Test public void test_932() {
		checkIsSubtype("[!int]","[[null]]");
	}
	@Test public void test_933() {
		checkIsSubtype("[!int]","[[int]]");
	}
	@Test public void test_934() {
		checkNotSubtype("[!int]","[!void]");
	}
	@Test public void test_935() {
		checkIsSubtype("[!int]","[!any]");
	}
	@Test public void test_936() {
		checkNotSubtype("[!int]","[!null]");
	}
	@Test public void test_937() {
		checkIsSubtype("[!int]","[!int]");
	}
	@Test public void test_938() {
		checkIsSubtype("[!int]","void|void");
	}
	@Test public void test_939() {
		checkNotSubtype("[!int]","void|any");
	}
	@Test public void test_940() {
		checkNotSubtype("[!int]","void|null");
	}
	@Test public void test_941() {
		checkNotSubtype("[!int]","void|int");
	}
	@Test public void test_942() {
		checkNotSubtype("[!int]","any|void");
	}
	@Test public void test_943() {
		checkNotSubtype("[!int]","any|any");
	}
	@Test public void test_944() {
		checkNotSubtype("[!int]","any|null");
	}
	@Test public void test_945() {
		checkNotSubtype("[!int]","any|int");
	}
	@Test public void test_946() {
		checkNotSubtype("[!int]","null|void");
	}
	@Test public void test_947() {
		checkNotSubtype("[!int]","null|any");
	}
	@Test public void test_948() {
		checkNotSubtype("[!int]","null|null");
	}
	@Test public void test_949() {
		checkNotSubtype("[!int]","null|int");
	}
	@Test public void test_950() {
		checkNotSubtype("[!int]","int|void");
	}
	@Test public void test_951() {
		checkNotSubtype("[!int]","int|any");
	}
	@Test public void test_952() {
		checkNotSubtype("[!int]","int|null");
	}
	@Test public void test_953() {
		checkNotSubtype("[!int]","int|int");
	}
	@Test public void test_954() {
		checkIsSubtype("[!int]","[void]|void");
	}
	@Test public void test_955() {
		checkNotSubtype("[!int]","[any]|any");
	}
	@Test public void test_956() {
		checkNotSubtype("[!int]","[null]|null");
	}
	@Test public void test_957() {
		checkNotSubtype("[!int]","[int]|int");
	}
	@Test public void test_958() {
		checkNotSubtype("[!int]","!void|void");
	}
	@Test public void test_959() {
		checkNotSubtype("[!int]","!any|any");
	}
	@Test public void test_960() {
		checkNotSubtype("[!int]","!null|null");
	}
	@Test public void test_961() {
		checkNotSubtype("[!int]","!int|int");
	}
	@Test public void test_962() {
		checkNotSubtype("[!int]","![void]");
	}
	@Test public void test_963() {
		checkNotSubtype("[!int]","![any]");
	}
	@Test public void test_964() {
		checkNotSubtype("[!int]","![null]");
	}
	@Test public void test_965() {
		checkNotSubtype("[!int]","![int]");
	}
	@Test public void test_966() {
		checkIsSubtype("[!int]","!!void");
	}
	@Test public void test_967() {
		checkNotSubtype("[!int]","!!any");
	}
	@Test public void test_968() {
		checkNotSubtype("[!int]","!!null");
	}
	@Test public void test_969() {
		checkNotSubtype("[!int]","!!int");
	}
	@Test public void test_970() {
		checkNotSubtype("void|void","any");
	}
	@Test public void test_971() {
		checkNotSubtype("void|void","null");
	}
	@Test public void test_972() {
		checkNotSubtype("void|void","int");
	}
	@Test public void test_973() {
		checkNotSubtype("void|void","[void]");
	}
	@Test public void test_974() {
		checkNotSubtype("void|void","[any]");
	}
	@Test public void test_975() {
		checkNotSubtype("void|void","[null]");
	}
	@Test public void test_976() {
		checkNotSubtype("void|void","[int]");
	}
	@Test public void test_977() {
		checkNotSubtype("void|void","!void");
	}
	@Test public void test_978() {
		checkIsSubtype("void|void","!any");
	}
	@Test public void test_979() {
		checkNotSubtype("void|void","!null");
	}
	@Test public void test_980() {
		checkNotSubtype("void|void","!int");
	}
	@Test public void test_981() {
		checkNotSubtype("void|void","[[void]]");
	}
	@Test public void test_982() {
		checkNotSubtype("void|void","[[any]]");
	}
	@Test public void test_983() {
		checkNotSubtype("void|void","[[null]]");
	}
	@Test public void test_984() {
		checkNotSubtype("void|void","[[int]]");
	}
	@Test public void test_985() {
		checkNotSubtype("void|void","[!void]");
	}
	@Test public void test_986() {
		checkNotSubtype("void|void","[!any]");
	}
	@Test public void test_987() {
		checkNotSubtype("void|void","[!null]");
	}
	@Test public void test_988() {
		checkNotSubtype("void|void","[!int]");
	}
	@Test public void test_989() {
		checkIsSubtype("void|void","void|void");
	}
	@Test public void test_990() {
		checkNotSubtype("void|void","void|any");
	}
	@Test public void test_991() {
		checkNotSubtype("void|void","void|null");
	}
	@Test public void test_992() {
		checkNotSubtype("void|void","void|int");
	}
	@Test public void test_993() {
		checkNotSubtype("void|void","any|void");
	}
	@Test public void test_994() {
		checkNotSubtype("void|void","any|any");
	}
	@Test public void test_995() {
		checkNotSubtype("void|void","any|null");
	}
	@Test public void test_996() {
		checkNotSubtype("void|void","any|int");
	}
	@Test public void test_997() {
		checkNotSubtype("void|void","null|void");
	}
	@Test public void test_998() {
		checkNotSubtype("void|void","null|any");
	}
	@Test public void test_999() {
		checkNotSubtype("void|void","null|null");
	}
	@Test public void test_1000() {
		checkNotSubtype("void|void","null|int");
	}
	@Test public void test_1001() {
		checkNotSubtype("void|void","int|void");
	}
	@Test public void test_1002() {
		checkNotSubtype("void|void","int|any");
	}
	@Test public void test_1003() {
		checkNotSubtype("void|void","int|null");
	}
	@Test public void test_1004() {
		checkNotSubtype("void|void","int|int");
	}
	@Test public void test_1005() {
		checkNotSubtype("void|void","[void]|void");
	}
	@Test public void test_1006() {
		checkNotSubtype("void|void","[any]|any");
	}
	@Test public void test_1007() {
		checkNotSubtype("void|void","[null]|null");
	}
	@Test public void test_1008() {
		checkNotSubtype("void|void","[int]|int");
	}
	@Test public void test_1009() {
		checkNotSubtype("void|void","!void|void");
	}
	@Test public void test_1010() {
		checkNotSubtype("void|void","!any|any");
	}
	@Test public void test_1011() {
		checkNotSubtype("void|void","!null|null");
	}
	@Test public void test_1012() {
		checkNotSubtype("void|void","!int|int");
	}
	@Test public void test_1013() {
		checkNotSubtype("void|void","![void]");
	}
	@Test public void test_1014() {
		checkNotSubtype("void|void","![any]");
	}
	@Test public void test_1015() {
		checkNotSubtype("void|void","![null]");
	}
	@Test public void test_1016() {
		checkNotSubtype("void|void","![int]");
	}
	@Test public void test_1017() {
		checkIsSubtype("void|void","!!void");
	}
	@Test public void test_1018() {
		checkNotSubtype("void|void","!!any");
	}
	@Test public void test_1019() {
		checkNotSubtype("void|void","!!null");
	}
	@Test public void test_1020() {
		checkNotSubtype("void|void","!!int");
	}
	@Test public void test_1021() {
		checkIsSubtype("void|any","any");
	}
	@Test public void test_1022() {
		checkIsSubtype("void|any","null");
	}
	@Test public void test_1023() {
		checkIsSubtype("void|any","int");
	}
	@Test public void test_1024() {
		checkIsSubtype("void|any","[void]");
	}
	@Test public void test_1025() {
		checkIsSubtype("void|any","[any]");
	}
	@Test public void test_1026() {
		checkIsSubtype("void|any","[null]");
	}
	@Test public void test_1027() {
		checkIsSubtype("void|any","[int]");
	}
	@Test public void test_1028() {
		checkIsSubtype("void|any","!void");
	}
	@Test public void test_1029() {
		checkIsSubtype("void|any","!any");
	}
	@Test public void test_1030() {
		checkIsSubtype("void|any","!null");
	}
	@Test public void test_1031() {
		checkIsSubtype("void|any","!int");
	}
	@Test public void test_1032() {
		checkIsSubtype("void|any","[[void]]");
	}
	@Test public void test_1033() {
		checkIsSubtype("void|any","[[any]]");
	}
	@Test public void test_1034() {
		checkIsSubtype("void|any","[[null]]");
	}
	@Test public void test_1035() {
		checkIsSubtype("void|any","[[int]]");
	}
	@Test public void test_1036() {
		checkIsSubtype("void|any","[!void]");
	}
	@Test public void test_1037() {
		checkIsSubtype("void|any","[!any]");
	}
	@Test public void test_1038() {
		checkIsSubtype("void|any","[!null]");
	}
	@Test public void test_1039() {
		checkIsSubtype("void|any","[!int]");
	}
	@Test public void test_1040() {
		checkIsSubtype("void|any","void|void");
	}
	@Test public void test_1041() {
		checkIsSubtype("void|any","void|any");
	}
	@Test public void test_1042() {
		checkIsSubtype("void|any","void|null");
	}
	@Test public void test_1043() {
		checkIsSubtype("void|any","void|int");
	}
	@Test public void test_1044() {
		checkIsSubtype("void|any","any|void");
	}
	@Test public void test_1045() {
		checkIsSubtype("void|any","any|any");
	}
	@Test public void test_1046() {
		checkIsSubtype("void|any","any|null");
	}
	@Test public void test_1047() {
		checkIsSubtype("void|any","any|int");
	}
	@Test public void test_1048() {
		checkIsSubtype("void|any","null|void");
	}
	@Test public void test_1049() {
		checkIsSubtype("void|any","null|any");
	}
	@Test public void test_1050() {
		checkIsSubtype("void|any","null|null");
	}
	@Test public void test_1051() {
		checkIsSubtype("void|any","null|int");
	}
	@Test public void test_1052() {
		checkIsSubtype("void|any","int|void");
	}
	@Test public void test_1053() {
		checkIsSubtype("void|any","int|any");
	}
	@Test public void test_1054() {
		checkIsSubtype("void|any","int|null");
	}
	@Test public void test_1055() {
		checkIsSubtype("void|any","int|int");
	}
	@Test public void test_1056() {
		checkIsSubtype("void|any","[void]|void");
	}
	@Test public void test_1057() {
		checkIsSubtype("void|any","[any]|any");
	}
	@Test public void test_1058() {
		checkIsSubtype("void|any","[null]|null");
	}
	@Test public void test_1059() {
		checkIsSubtype("void|any","[int]|int");
	}
	@Test public void test_1060() {
		checkIsSubtype("void|any","!void|void");
	}
	@Test public void test_1061() {
		checkIsSubtype("void|any","!any|any");
	}
	@Test public void test_1062() {
		checkIsSubtype("void|any","!null|null");
	}
	@Test public void test_1063() {
		checkIsSubtype("void|any","!int|int");
	}
	@Test public void test_1064() {
		checkIsSubtype("void|any","![void]");
	}
	@Test public void test_1065() {
		checkIsSubtype("void|any","![any]");
	}
	@Test public void test_1066() {
		checkIsSubtype("void|any","![null]");
	}
	@Test public void test_1067() {
		checkIsSubtype("void|any","![int]");
	}
	@Test public void test_1068() {
		checkIsSubtype("void|any","!!void");
	}
	@Test public void test_1069() {
		checkIsSubtype("void|any","!!any");
	}
	@Test public void test_1070() {
		checkIsSubtype("void|any","!!null");
	}
	@Test public void test_1071() {
		checkIsSubtype("void|any","!!int");
	}
	@Test public void test_1072() {
		checkNotSubtype("void|null","any");
	}
	@Test public void test_1073() {
		checkIsSubtype("void|null","null");
	}
	@Test public void test_1074() {
		checkNotSubtype("void|null","int");
	}
	@Test public void test_1075() {
		checkNotSubtype("void|null","[void]");
	}
	@Test public void test_1076() {
		checkNotSubtype("void|null","[any]");
	}
	@Test public void test_1077() {
		checkNotSubtype("void|null","[null]");
	}
	@Test public void test_1078() {
		checkNotSubtype("void|null","[int]");
	}
	@Test public void test_1079() {
		checkNotSubtype("void|null","!void");
	}
	@Test public void test_1080() {
		checkIsSubtype("void|null","!any");
	}
	@Test public void test_1081() {
		checkNotSubtype("void|null","!null");
	}
	@Test public void test_1082() {
		checkNotSubtype("void|null","!int");
	}
	@Test public void test_1083() {
		checkNotSubtype("void|null","[[void]]");
	}
	@Test public void test_1084() {
		checkNotSubtype("void|null","[[any]]");
	}
	@Test public void test_1085() {
		checkNotSubtype("void|null","[[null]]");
	}
	@Test public void test_1086() {
		checkNotSubtype("void|null","[[int]]");
	}
	@Test public void test_1087() {
		checkNotSubtype("void|null","[!void]");
	}
	@Test public void test_1088() {
		checkNotSubtype("void|null","[!any]");
	}
	@Test public void test_1089() {
		checkNotSubtype("void|null","[!null]");
	}
	@Test public void test_1090() {
		checkNotSubtype("void|null","[!int]");
	}
	@Test public void test_1091() {
		checkIsSubtype("void|null","void|void");
	}
	@Test public void test_1092() {
		checkNotSubtype("void|null","void|any");
	}
	@Test public void test_1093() {
		checkIsSubtype("void|null","void|null");
	}
	@Test public void test_1094() {
		checkNotSubtype("void|null","void|int");
	}
	@Test public void test_1095() {
		checkNotSubtype("void|null","any|void");
	}
	@Test public void test_1096() {
		checkNotSubtype("void|null","any|any");
	}
	@Test public void test_1097() {
		checkNotSubtype("void|null","any|null");
	}
	@Test public void test_1098() {
		checkNotSubtype("void|null","any|int");
	}
	@Test public void test_1099() {
		checkIsSubtype("void|null","null|void");
	}
	@Test public void test_1100() {
		checkNotSubtype("void|null","null|any");
	}
	@Test public void test_1101() {
		checkIsSubtype("void|null","null|null");
	}
	@Test public void test_1102() {
		checkNotSubtype("void|null","null|int");
	}
	@Test public void test_1103() {
		checkNotSubtype("void|null","int|void");
	}
	@Test public void test_1104() {
		checkNotSubtype("void|null","int|any");
	}
	@Test public void test_1105() {
		checkNotSubtype("void|null","int|null");
	}
	@Test public void test_1106() {
		checkNotSubtype("void|null","int|int");
	}
	@Test public void test_1107() {
		checkNotSubtype("void|null","[void]|void");
	}
	@Test public void test_1108() {
		checkNotSubtype("void|null","[any]|any");
	}
	@Test public void test_1109() {
		checkNotSubtype("void|null","[null]|null");
	}
	@Test public void test_1110() {
		checkNotSubtype("void|null","[int]|int");
	}
	@Test public void test_1111() {
		checkNotSubtype("void|null","!void|void");
	}
	@Test public void test_1112() {
		checkNotSubtype("void|null","!any|any");
	}
	@Test public void test_1113() {
		checkNotSubtype("void|null","!null|null");
	}
	@Test public void test_1114() {
		checkNotSubtype("void|null","!int|int");
	}
	@Test public void test_1115() {
		checkNotSubtype("void|null","![void]");
	}
	@Test public void test_1116() {
		checkNotSubtype("void|null","![any]");
	}
	@Test public void test_1117() {
		checkNotSubtype("void|null","![null]");
	}
	@Test public void test_1118() {
		checkNotSubtype("void|null","![int]");
	}
	@Test public void test_1119() {
		checkIsSubtype("void|null","!!void");
	}
	@Test public void test_1120() {
		checkNotSubtype("void|null","!!any");
	}
	@Test public void test_1121() {
		checkIsSubtype("void|null","!!null");
	}
	@Test public void test_1122() {
		checkNotSubtype("void|null","!!int");
	}
	@Test public void test_1123() {
		checkNotSubtype("void|int","any");
	}
	@Test public void test_1124() {
		checkNotSubtype("void|int","null");
	}
	@Test public void test_1125() {
		checkIsSubtype("void|int","int");
	}
	@Test public void test_1126() {
		checkNotSubtype("void|int","[void]");
	}
	@Test public void test_1127() {
		checkNotSubtype("void|int","[any]");
	}
	@Test public void test_1128() {
		checkNotSubtype("void|int","[null]");
	}
	@Test public void test_1129() {
		checkNotSubtype("void|int","[int]");
	}
	@Test public void test_1130() {
		checkNotSubtype("void|int","!void");
	}
	@Test public void test_1131() {
		checkIsSubtype("void|int","!any");
	}
	@Test public void test_1132() {
		checkNotSubtype("void|int","!null");
	}
	@Test public void test_1133() {
		checkNotSubtype("void|int","!int");
	}
	@Test public void test_1134() {
		checkNotSubtype("void|int","[[void]]");
	}
	@Test public void test_1135() {
		checkNotSubtype("void|int","[[any]]");
	}
	@Test public void test_1136() {
		checkNotSubtype("void|int","[[null]]");
	}
	@Test public void test_1137() {
		checkNotSubtype("void|int","[[int]]");
	}
	@Test public void test_1138() {
		checkNotSubtype("void|int","[!void]");
	}
	@Test public void test_1139() {
		checkNotSubtype("void|int","[!any]");
	}
	@Test public void test_1140() {
		checkNotSubtype("void|int","[!null]");
	}
	@Test public void test_1141() {
		checkNotSubtype("void|int","[!int]");
	}
	@Test public void test_1142() {
		checkIsSubtype("void|int","void|void");
	}
	@Test public void test_1143() {
		checkNotSubtype("void|int","void|any");
	}
	@Test public void test_1144() {
		checkNotSubtype("void|int","void|null");
	}
	@Test public void test_1145() {
		checkIsSubtype("void|int","void|int");
	}
	@Test public void test_1146() {
		checkNotSubtype("void|int","any|void");
	}
	@Test public void test_1147() {
		checkNotSubtype("void|int","any|any");
	}
	@Test public void test_1148() {
		checkNotSubtype("void|int","any|null");
	}
	@Test public void test_1149() {
		checkNotSubtype("void|int","any|int");
	}
	@Test public void test_1150() {
		checkNotSubtype("void|int","null|void");
	}
	@Test public void test_1151() {
		checkNotSubtype("void|int","null|any");
	}
	@Test public void test_1152() {
		checkNotSubtype("void|int","null|null");
	}
	@Test public void test_1153() {
		checkNotSubtype("void|int","null|int");
	}
	@Test public void test_1154() {
		checkIsSubtype("void|int","int|void");
	}
	@Test public void test_1155() {
		checkNotSubtype("void|int","int|any");
	}
	@Test public void test_1156() {
		checkNotSubtype("void|int","int|null");
	}
	@Test public void test_1157() {
		checkIsSubtype("void|int","int|int");
	}
	@Test public void test_1158() {
		checkNotSubtype("void|int","[void]|void");
	}
	@Test public void test_1159() {
		checkNotSubtype("void|int","[any]|any");
	}
	@Test public void test_1160() {
		checkNotSubtype("void|int","[null]|null");
	}
	@Test public void test_1161() {
		checkNotSubtype("void|int","[int]|int");
	}
	@Test public void test_1162() {
		checkNotSubtype("void|int","!void|void");
	}
	@Test public void test_1163() {
		checkNotSubtype("void|int","!any|any");
	}
	@Test public void test_1164() {
		checkNotSubtype("void|int","!null|null");
	}
	@Test public void test_1165() {
		checkNotSubtype("void|int","!int|int");
	}
	@Test public void test_1166() {
		checkNotSubtype("void|int","![void]");
	}
	@Test public void test_1167() {
		checkNotSubtype("void|int","![any]");
	}
	@Test public void test_1168() {
		checkNotSubtype("void|int","![null]");
	}
	@Test public void test_1169() {
		checkNotSubtype("void|int","![int]");
	}
	@Test public void test_1170() {
		checkIsSubtype("void|int","!!void");
	}
	@Test public void test_1171() {
		checkNotSubtype("void|int","!!any");
	}
	@Test public void test_1172() {
		checkNotSubtype("void|int","!!null");
	}
	@Test public void test_1173() {
		checkIsSubtype("void|int","!!int");
	}
	@Test public void test_1174() {
		checkIsSubtype("any|void","any");
	}
	@Test public void test_1175() {
		checkIsSubtype("any|void","null");
	}
	@Test public void test_1176() {
		checkIsSubtype("any|void","int");
	}
	@Test public void test_1177() {
		checkIsSubtype("any|void","[void]");
	}
	@Test public void test_1178() {
		checkIsSubtype("any|void","[any]");
	}
	@Test public void test_1179() {
		checkIsSubtype("any|void","[null]");
	}
	@Test public void test_1180() {
		checkIsSubtype("any|void","[int]");
	}
	@Test public void test_1181() {
		checkIsSubtype("any|void","!void");
	}
	@Test public void test_1182() {
		checkIsSubtype("any|void","!any");
	}
	@Test public void test_1183() {
		checkIsSubtype("any|void","!null");
	}
	@Test public void test_1184() {
		checkIsSubtype("any|void","!int");
	}
	@Test public void test_1185() {
		checkIsSubtype("any|void","[[void]]");
	}
	@Test public void test_1186() {
		checkIsSubtype("any|void","[[any]]");
	}
	@Test public void test_1187() {
		checkIsSubtype("any|void","[[null]]");
	}
	@Test public void test_1188() {
		checkIsSubtype("any|void","[[int]]");
	}
	@Test public void test_1189() {
		checkIsSubtype("any|void","[!void]");
	}
	@Test public void test_1190() {
		checkIsSubtype("any|void","[!any]");
	}
	@Test public void test_1191() {
		checkIsSubtype("any|void","[!null]");
	}
	@Test public void test_1192() {
		checkIsSubtype("any|void","[!int]");
	}
	@Test public void test_1193() {
		checkIsSubtype("any|void","void|void");
	}
	@Test public void test_1194() {
		checkIsSubtype("any|void","void|any");
	}
	@Test public void test_1195() {
		checkIsSubtype("any|void","void|null");
	}
	@Test public void test_1196() {
		checkIsSubtype("any|void","void|int");
	}
	@Test public void test_1197() {
		checkIsSubtype("any|void","any|void");
	}
	@Test public void test_1198() {
		checkIsSubtype("any|void","any|any");
	}
	@Test public void test_1199() {
		checkIsSubtype("any|void","any|null");
	}
	@Test public void test_1200() {
		checkIsSubtype("any|void","any|int");
	}
	@Test public void test_1201() {
		checkIsSubtype("any|void","null|void");
	}
	@Test public void test_1202() {
		checkIsSubtype("any|void","null|any");
	}
	@Test public void test_1203() {
		checkIsSubtype("any|void","null|null");
	}
	@Test public void test_1204() {
		checkIsSubtype("any|void","null|int");
	}
	@Test public void test_1205() {
		checkIsSubtype("any|void","int|void");
	}
	@Test public void test_1206() {
		checkIsSubtype("any|void","int|any");
	}
	@Test public void test_1207() {
		checkIsSubtype("any|void","int|null");
	}
	@Test public void test_1208() {
		checkIsSubtype("any|void","int|int");
	}
	@Test public void test_1209() {
		checkIsSubtype("any|void","[void]|void");
	}
	@Test public void test_1210() {
		checkIsSubtype("any|void","[any]|any");
	}
	@Test public void test_1211() {
		checkIsSubtype("any|void","[null]|null");
	}
	@Test public void test_1212() {
		checkIsSubtype("any|void","[int]|int");
	}
	@Test public void test_1213() {
		checkIsSubtype("any|void","!void|void");
	}
	@Test public void test_1214() {
		checkIsSubtype("any|void","!any|any");
	}
	@Test public void test_1215() {
		checkIsSubtype("any|void","!null|null");
	}
	@Test public void test_1216() {
		checkIsSubtype("any|void","!int|int");
	}
	@Test public void test_1217() {
		checkIsSubtype("any|void","![void]");
	}
	@Test public void test_1218() {
		checkIsSubtype("any|void","![any]");
	}
	@Test public void test_1219() {
		checkIsSubtype("any|void","![null]");
	}
	@Test public void test_1220() {
		checkIsSubtype("any|void","![int]");
	}
	@Test public void test_1221() {
		checkIsSubtype("any|void","!!void");
	}
	@Test public void test_1222() {
		checkIsSubtype("any|void","!!any");
	}
	@Test public void test_1223() {
		checkIsSubtype("any|void","!!null");
	}
	@Test public void test_1224() {
		checkIsSubtype("any|void","!!int");
	}
	@Test public void test_1225() {
		checkIsSubtype("any|any","any");
	}
	@Test public void test_1226() {
		checkIsSubtype("any|any","null");
	}
	@Test public void test_1227() {
		checkIsSubtype("any|any","int");
	}
	@Test public void test_1228() {
		checkIsSubtype("any|any","[void]");
	}
	@Test public void test_1229() {
		checkIsSubtype("any|any","[any]");
	}
	@Test public void test_1230() {
		checkIsSubtype("any|any","[null]");
	}
	@Test public void test_1231() {
		checkIsSubtype("any|any","[int]");
	}
	@Test public void test_1232() {
		checkIsSubtype("any|any","!void");
	}
	@Test public void test_1233() {
		checkIsSubtype("any|any","!any");
	}
	@Test public void test_1234() {
		checkIsSubtype("any|any","!null");
	}
	@Test public void test_1235() {
		checkIsSubtype("any|any","!int");
	}
	@Test public void test_1236() {
		checkIsSubtype("any|any","[[void]]");
	}
	@Test public void test_1237() {
		checkIsSubtype("any|any","[[any]]");
	}
	@Test public void test_1238() {
		checkIsSubtype("any|any","[[null]]");
	}
	@Test public void test_1239() {
		checkIsSubtype("any|any","[[int]]");
	}
	@Test public void test_1240() {
		checkIsSubtype("any|any","[!void]");
	}
	@Test public void test_1241() {
		checkIsSubtype("any|any","[!any]");
	}
	@Test public void test_1242() {
		checkIsSubtype("any|any","[!null]");
	}
	@Test public void test_1243() {
		checkIsSubtype("any|any","[!int]");
	}
	@Test public void test_1244() {
		checkIsSubtype("any|any","void|void");
	}
	@Test public void test_1245() {
		checkIsSubtype("any|any","void|any");
	}
	@Test public void test_1246() {
		checkIsSubtype("any|any","void|null");
	}
	@Test public void test_1247() {
		checkIsSubtype("any|any","void|int");
	}
	@Test public void test_1248() {
		checkIsSubtype("any|any","any|void");
	}
	@Test public void test_1249() {
		checkIsSubtype("any|any","any|any");
	}
	@Test public void test_1250() {
		checkIsSubtype("any|any","any|null");
	}
	@Test public void test_1251() {
		checkIsSubtype("any|any","any|int");
	}
	@Test public void test_1252() {
		checkIsSubtype("any|any","null|void");
	}
	@Test public void test_1253() {
		checkIsSubtype("any|any","null|any");
	}
	@Test public void test_1254() {
		checkIsSubtype("any|any","null|null");
	}
	@Test public void test_1255() {
		checkIsSubtype("any|any","null|int");
	}
	@Test public void test_1256() {
		checkIsSubtype("any|any","int|void");
	}
	@Test public void test_1257() {
		checkIsSubtype("any|any","int|any");
	}
	@Test public void test_1258() {
		checkIsSubtype("any|any","int|null");
	}
	@Test public void test_1259() {
		checkIsSubtype("any|any","int|int");
	}
	@Test public void test_1260() {
		checkIsSubtype("any|any","[void]|void");
	}
	@Test public void test_1261() {
		checkIsSubtype("any|any","[any]|any");
	}
	@Test public void test_1262() {
		checkIsSubtype("any|any","[null]|null");
	}
	@Test public void test_1263() {
		checkIsSubtype("any|any","[int]|int");
	}
	@Test public void test_1264() {
		checkIsSubtype("any|any","!void|void");
	}
	@Test public void test_1265() {
		checkIsSubtype("any|any","!any|any");
	}
	@Test public void test_1266() {
		checkIsSubtype("any|any","!null|null");
	}
	@Test public void test_1267() {
		checkIsSubtype("any|any","!int|int");
	}
	@Test public void test_1268() {
		checkIsSubtype("any|any","![void]");
	}
	@Test public void test_1269() {
		checkIsSubtype("any|any","![any]");
	}
	@Test public void test_1270() {
		checkIsSubtype("any|any","![null]");
	}
	@Test public void test_1271() {
		checkIsSubtype("any|any","![int]");
	}
	@Test public void test_1272() {
		checkIsSubtype("any|any","!!void");
	}
	@Test public void test_1273() {
		checkIsSubtype("any|any","!!any");
	}
	@Test public void test_1274() {
		checkIsSubtype("any|any","!!null");
	}
	@Test public void test_1275() {
		checkIsSubtype("any|any","!!int");
	}
	@Test public void test_1276() {
		checkIsSubtype("any|null","any");
	}
	@Test public void test_1277() {
		checkIsSubtype("any|null","null");
	}
	@Test public void test_1278() {
		checkIsSubtype("any|null","int");
	}
	@Test public void test_1279() {
		checkIsSubtype("any|null","[void]");
	}
	@Test public void test_1280() {
		checkIsSubtype("any|null","[any]");
	}
	@Test public void test_1281() {
		checkIsSubtype("any|null","[null]");
	}
	@Test public void test_1282() {
		checkIsSubtype("any|null","[int]");
	}
	@Test public void test_1283() {
		checkIsSubtype("any|null","!void");
	}
	@Test public void test_1284() {
		checkIsSubtype("any|null","!any");
	}
	@Test public void test_1285() {
		checkIsSubtype("any|null","!null");
	}
	@Test public void test_1286() {
		checkIsSubtype("any|null","!int");
	}
	@Test public void test_1287() {
		checkIsSubtype("any|null","[[void]]");
	}
	@Test public void test_1288() {
		checkIsSubtype("any|null","[[any]]");
	}
	@Test public void test_1289() {
		checkIsSubtype("any|null","[[null]]");
	}
	@Test public void test_1290() {
		checkIsSubtype("any|null","[[int]]");
	}
	@Test public void test_1291() {
		checkIsSubtype("any|null","[!void]");
	}
	@Test public void test_1292() {
		checkIsSubtype("any|null","[!any]");
	}
	@Test public void test_1293() {
		checkIsSubtype("any|null","[!null]");
	}
	@Test public void test_1294() {
		checkIsSubtype("any|null","[!int]");
	}
	@Test public void test_1295() {
		checkIsSubtype("any|null","void|void");
	}
	@Test public void test_1296() {
		checkIsSubtype("any|null","void|any");
	}
	@Test public void test_1297() {
		checkIsSubtype("any|null","void|null");
	}
	@Test public void test_1298() {
		checkIsSubtype("any|null","void|int");
	}
	@Test public void test_1299() {
		checkIsSubtype("any|null","any|void");
	}
	@Test public void test_1300() {
		checkIsSubtype("any|null","any|any");
	}
	@Test public void test_1301() {
		checkIsSubtype("any|null","any|null");
	}
	@Test public void test_1302() {
		checkIsSubtype("any|null","any|int");
	}
	@Test public void test_1303() {
		checkIsSubtype("any|null","null|void");
	}
	@Test public void test_1304() {
		checkIsSubtype("any|null","null|any");
	}
	@Test public void test_1305() {
		checkIsSubtype("any|null","null|null");
	}
	@Test public void test_1306() {
		checkIsSubtype("any|null","null|int");
	}
	@Test public void test_1307() {
		checkIsSubtype("any|null","int|void");
	}
	@Test public void test_1308() {
		checkIsSubtype("any|null","int|any");
	}
	@Test public void test_1309() {
		checkIsSubtype("any|null","int|null");
	}
	@Test public void test_1310() {
		checkIsSubtype("any|null","int|int");
	}
	@Test public void test_1311() {
		checkIsSubtype("any|null","[void]|void");
	}
	@Test public void test_1312() {
		checkIsSubtype("any|null","[any]|any");
	}
	@Test public void test_1313() {
		checkIsSubtype("any|null","[null]|null");
	}
	@Test public void test_1314() {
		checkIsSubtype("any|null","[int]|int");
	}
	@Test public void test_1315() {
		checkIsSubtype("any|null","!void|void");
	}
	@Test public void test_1316() {
		checkIsSubtype("any|null","!any|any");
	}
	@Test public void test_1317() {
		checkIsSubtype("any|null","!null|null");
	}
	@Test public void test_1318() {
		checkIsSubtype("any|null","!int|int");
	}
	@Test public void test_1319() {
		checkIsSubtype("any|null","![void]");
	}
	@Test public void test_1320() {
		checkIsSubtype("any|null","![any]");
	}
	@Test public void test_1321() {
		checkIsSubtype("any|null","![null]");
	}
	@Test public void test_1322() {
		checkIsSubtype("any|null","![int]");
	}
	@Test public void test_1323() {
		checkIsSubtype("any|null","!!void");
	}
	@Test public void test_1324() {
		checkIsSubtype("any|null","!!any");
	}
	@Test public void test_1325() {
		checkIsSubtype("any|null","!!null");
	}
	@Test public void test_1326() {
		checkIsSubtype("any|null","!!int");
	}
	@Test public void test_1327() {
		checkIsSubtype("any|int","any");
	}
	@Test public void test_1328() {
		checkIsSubtype("any|int","null");
	}
	@Test public void test_1329() {
		checkIsSubtype("any|int","int");
	}
	@Test public void test_1330() {
		checkIsSubtype("any|int","[void]");
	}
	@Test public void test_1331() {
		checkIsSubtype("any|int","[any]");
	}
	@Test public void test_1332() {
		checkIsSubtype("any|int","[null]");
	}
	@Test public void test_1333() {
		checkIsSubtype("any|int","[int]");
	}
	@Test public void test_1334() {
		checkIsSubtype("any|int","!void");
	}
	@Test public void test_1335() {
		checkIsSubtype("any|int","!any");
	}
	@Test public void test_1336() {
		checkIsSubtype("any|int","!null");
	}
	@Test public void test_1337() {
		checkIsSubtype("any|int","!int");
	}
	@Test public void test_1338() {
		checkIsSubtype("any|int","[[void]]");
	}
	@Test public void test_1339() {
		checkIsSubtype("any|int","[[any]]");
	}
	@Test public void test_1340() {
		checkIsSubtype("any|int","[[null]]");
	}
	@Test public void test_1341() {
		checkIsSubtype("any|int","[[int]]");
	}
	@Test public void test_1342() {
		checkIsSubtype("any|int","[!void]");
	}
	@Test public void test_1343() {
		checkIsSubtype("any|int","[!any]");
	}
	@Test public void test_1344() {
		checkIsSubtype("any|int","[!null]");
	}
	@Test public void test_1345() {
		checkIsSubtype("any|int","[!int]");
	}
	@Test public void test_1346() {
		checkIsSubtype("any|int","void|void");
	}
	@Test public void test_1347() {
		checkIsSubtype("any|int","void|any");
	}
	@Test public void test_1348() {
		checkIsSubtype("any|int","void|null");
	}
	@Test public void test_1349() {
		checkIsSubtype("any|int","void|int");
	}
	@Test public void test_1350() {
		checkIsSubtype("any|int","any|void");
	}
	@Test public void test_1351() {
		checkIsSubtype("any|int","any|any");
	}
	@Test public void test_1352() {
		checkIsSubtype("any|int","any|null");
	}
	@Test public void test_1353() {
		checkIsSubtype("any|int","any|int");
	}
	@Test public void test_1354() {
		checkIsSubtype("any|int","null|void");
	}
	@Test public void test_1355() {
		checkIsSubtype("any|int","null|any");
	}
	@Test public void test_1356() {
		checkIsSubtype("any|int","null|null");
	}
	@Test public void test_1357() {
		checkIsSubtype("any|int","null|int");
	}
	@Test public void test_1358() {
		checkIsSubtype("any|int","int|void");
	}
	@Test public void test_1359() {
		checkIsSubtype("any|int","int|any");
	}
	@Test public void test_1360() {
		checkIsSubtype("any|int","int|null");
	}
	@Test public void test_1361() {
		checkIsSubtype("any|int","int|int");
	}
	@Test public void test_1362() {
		checkIsSubtype("any|int","[void]|void");
	}
	@Test public void test_1363() {
		checkIsSubtype("any|int","[any]|any");
	}
	@Test public void test_1364() {
		checkIsSubtype("any|int","[null]|null");
	}
	@Test public void test_1365() {
		checkIsSubtype("any|int","[int]|int");
	}
	@Test public void test_1366() {
		checkIsSubtype("any|int","!void|void");
	}
	@Test public void test_1367() {
		checkIsSubtype("any|int","!any|any");
	}
	@Test public void test_1368() {
		checkIsSubtype("any|int","!null|null");
	}
	@Test public void test_1369() {
		checkIsSubtype("any|int","!int|int");
	}
	@Test public void test_1370() {
		checkIsSubtype("any|int","![void]");
	}
	@Test public void test_1371() {
		checkIsSubtype("any|int","![any]");
	}
	@Test public void test_1372() {
		checkIsSubtype("any|int","![null]");
	}
	@Test public void test_1373() {
		checkIsSubtype("any|int","![int]");
	}
	@Test public void test_1374() {
		checkIsSubtype("any|int","!!void");
	}
	@Test public void test_1375() {
		checkIsSubtype("any|int","!!any");
	}
	@Test public void test_1376() {
		checkIsSubtype("any|int","!!null");
	}
	@Test public void test_1377() {
		checkIsSubtype("any|int","!!int");
	}
	@Test public void test_1378() {
		checkNotSubtype("null|void","any");
	}
	@Test public void test_1379() {
		checkIsSubtype("null|void","null");
	}
	@Test public void test_1380() {
		checkNotSubtype("null|void","int");
	}
	@Test public void test_1381() {
		checkNotSubtype("null|void","[void]");
	}
	@Test public void test_1382() {
		checkNotSubtype("null|void","[any]");
	}
	@Test public void test_1383() {
		checkNotSubtype("null|void","[null]");
	}
	@Test public void test_1384() {
		checkNotSubtype("null|void","[int]");
	}
	@Test public void test_1385() {
		checkNotSubtype("null|void","!void");
	}
	@Test public void test_1386() {
		checkIsSubtype("null|void","!any");
	}
	@Test public void test_1387() {
		checkNotSubtype("null|void","!null");
	}
	@Test public void test_1388() {
		checkNotSubtype("null|void","!int");
	}
	@Test public void test_1389() {
		checkNotSubtype("null|void","[[void]]");
	}
	@Test public void test_1390() {
		checkNotSubtype("null|void","[[any]]");
	}
	@Test public void test_1391() {
		checkNotSubtype("null|void","[[null]]");
	}
	@Test public void test_1392() {
		checkNotSubtype("null|void","[[int]]");
	}
	@Test public void test_1393() {
		checkNotSubtype("null|void","[!void]");
	}
	@Test public void test_1394() {
		checkNotSubtype("null|void","[!any]");
	}
	@Test public void test_1395() {
		checkNotSubtype("null|void","[!null]");
	}
	@Test public void test_1396() {
		checkNotSubtype("null|void","[!int]");
	}
	@Test public void test_1397() {
		checkIsSubtype("null|void","void|void");
	}
	@Test public void test_1398() {
		checkNotSubtype("null|void","void|any");
	}
	@Test public void test_1399() {
		checkIsSubtype("null|void","void|null");
	}
	@Test public void test_1400() {
		checkNotSubtype("null|void","void|int");
	}
	@Test public void test_1401() {
		checkNotSubtype("null|void","any|void");
	}
	@Test public void test_1402() {
		checkNotSubtype("null|void","any|any");
	}
	@Test public void test_1403() {
		checkNotSubtype("null|void","any|null");
	}
	@Test public void test_1404() {
		checkNotSubtype("null|void","any|int");
	}
	@Test public void test_1405() {
		checkIsSubtype("null|void","null|void");
	}
	@Test public void test_1406() {
		checkNotSubtype("null|void","null|any");
	}
	@Test public void test_1407() {
		checkIsSubtype("null|void","null|null");
	}
	@Test public void test_1408() {
		checkNotSubtype("null|void","null|int");
	}
	@Test public void test_1409() {
		checkNotSubtype("null|void","int|void");
	}
	@Test public void test_1410() {
		checkNotSubtype("null|void","int|any");
	}
	@Test public void test_1411() {
		checkNotSubtype("null|void","int|null");
	}
	@Test public void test_1412() {
		checkNotSubtype("null|void","int|int");
	}
	@Test public void test_1413() {
		checkNotSubtype("null|void","[void]|void");
	}
	@Test public void test_1414() {
		checkNotSubtype("null|void","[any]|any");
	}
	@Test public void test_1415() {
		checkNotSubtype("null|void","[null]|null");
	}
	@Test public void test_1416() {
		checkNotSubtype("null|void","[int]|int");
	}
	@Test public void test_1417() {
		checkNotSubtype("null|void","!void|void");
	}
	@Test public void test_1418() {
		checkNotSubtype("null|void","!any|any");
	}
	@Test public void test_1419() {
		checkNotSubtype("null|void","!null|null");
	}
	@Test public void test_1420() {
		checkNotSubtype("null|void","!int|int");
	}
	@Test public void test_1421() {
		checkNotSubtype("null|void","![void]");
	}
	@Test public void test_1422() {
		checkNotSubtype("null|void","![any]");
	}
	@Test public void test_1423() {
		checkNotSubtype("null|void","![null]");
	}
	@Test public void test_1424() {
		checkNotSubtype("null|void","![int]");
	}
	@Test public void test_1425() {
		checkIsSubtype("null|void","!!void");
	}
	@Test public void test_1426() {
		checkNotSubtype("null|void","!!any");
	}
	@Test public void test_1427() {
		checkIsSubtype("null|void","!!null");
	}
	@Test public void test_1428() {
		checkNotSubtype("null|void","!!int");
	}
	@Test public void test_1429() {
		checkIsSubtype("null|any","any");
	}
	@Test public void test_1430() {
		checkIsSubtype("null|any","null");
	}
	@Test public void test_1431() {
		checkIsSubtype("null|any","int");
	}
	@Test public void test_1432() {
		checkIsSubtype("null|any","[void]");
	}
	@Test public void test_1433() {
		checkIsSubtype("null|any","[any]");
	}
	@Test public void test_1434() {
		checkIsSubtype("null|any","[null]");
	}
	@Test public void test_1435() {
		checkIsSubtype("null|any","[int]");
	}
	@Test public void test_1436() {
		checkIsSubtype("null|any","!void");
	}
	@Test public void test_1437() {
		checkIsSubtype("null|any","!any");
	}
	@Test public void test_1438() {
		checkIsSubtype("null|any","!null");
	}
	@Test public void test_1439() {
		checkIsSubtype("null|any","!int");
	}
	@Test public void test_1440() {
		checkIsSubtype("null|any","[[void]]");
	}
	@Test public void test_1441() {
		checkIsSubtype("null|any","[[any]]");
	}
	@Test public void test_1442() {
		checkIsSubtype("null|any","[[null]]");
	}
	@Test public void test_1443() {
		checkIsSubtype("null|any","[[int]]");
	}
	@Test public void test_1444() {
		checkIsSubtype("null|any","[!void]");
	}
	@Test public void test_1445() {
		checkIsSubtype("null|any","[!any]");
	}
	@Test public void test_1446() {
		checkIsSubtype("null|any","[!null]");
	}
	@Test public void test_1447() {
		checkIsSubtype("null|any","[!int]");
	}
	@Test public void test_1448() {
		checkIsSubtype("null|any","void|void");
	}
	@Test public void test_1449() {
		checkIsSubtype("null|any","void|any");
	}
	@Test public void test_1450() {
		checkIsSubtype("null|any","void|null");
	}
	@Test public void test_1451() {
		checkIsSubtype("null|any","void|int");
	}
	@Test public void test_1452() {
		checkIsSubtype("null|any","any|void");
	}
	@Test public void test_1453() {
		checkIsSubtype("null|any","any|any");
	}
	@Test public void test_1454() {
		checkIsSubtype("null|any","any|null");
	}
	@Test public void test_1455() {
		checkIsSubtype("null|any","any|int");
	}
	@Test public void test_1456() {
		checkIsSubtype("null|any","null|void");
	}
	@Test public void test_1457() {
		checkIsSubtype("null|any","null|any");
	}
	@Test public void test_1458() {
		checkIsSubtype("null|any","null|null");
	}
	@Test public void test_1459() {
		checkIsSubtype("null|any","null|int");
	}
	@Test public void test_1460() {
		checkIsSubtype("null|any","int|void");
	}
	@Test public void test_1461() {
		checkIsSubtype("null|any","int|any");
	}
	@Test public void test_1462() {
		checkIsSubtype("null|any","int|null");
	}
	@Test public void test_1463() {
		checkIsSubtype("null|any","int|int");
	}
	@Test public void test_1464() {
		checkIsSubtype("null|any","[void]|void");
	}
	@Test public void test_1465() {
		checkIsSubtype("null|any","[any]|any");
	}
	@Test public void test_1466() {
		checkIsSubtype("null|any","[null]|null");
	}
	@Test public void test_1467() {
		checkIsSubtype("null|any","[int]|int");
	}
	@Test public void test_1468() {
		checkIsSubtype("null|any","!void|void");
	}
	@Test public void test_1469() {
		checkIsSubtype("null|any","!any|any");
	}
	@Test public void test_1470() {
		checkIsSubtype("null|any","!null|null");
	}
	@Test public void test_1471() {
		checkIsSubtype("null|any","!int|int");
	}
	@Test public void test_1472() {
		checkIsSubtype("null|any","![void]");
	}
	@Test public void test_1473() {
		checkIsSubtype("null|any","![any]");
	}
	@Test public void test_1474() {
		checkIsSubtype("null|any","![null]");
	}
	@Test public void test_1475() {
		checkIsSubtype("null|any","![int]");
	}
	@Test public void test_1476() {
		checkIsSubtype("null|any","!!void");
	}
	@Test public void test_1477() {
		checkIsSubtype("null|any","!!any");
	}
	@Test public void test_1478() {
		checkIsSubtype("null|any","!!null");
	}
	@Test public void test_1479() {
		checkIsSubtype("null|any","!!int");
	}
	@Test public void test_1480() {
		checkNotSubtype("null|null","any");
	}
	@Test public void test_1481() {
		checkIsSubtype("null|null","null");
	}
	@Test public void test_1482() {
		checkNotSubtype("null|null","int");
	}
	@Test public void test_1483() {
		checkNotSubtype("null|null","[void]");
	}
	@Test public void test_1484() {
		checkNotSubtype("null|null","[any]");
	}
	@Test public void test_1485() {
		checkNotSubtype("null|null","[null]");
	}
	@Test public void test_1486() {
		checkNotSubtype("null|null","[int]");
	}
	@Test public void test_1487() {
		checkNotSubtype("null|null","!void");
	}
	@Test public void test_1488() {
		checkIsSubtype("null|null","!any");
	}
	@Test public void test_1489() {
		checkNotSubtype("null|null","!null");
	}
	@Test public void test_1490() {
		checkNotSubtype("null|null","!int");
	}
	@Test public void test_1491() {
		checkNotSubtype("null|null","[[void]]");
	}
	@Test public void test_1492() {
		checkNotSubtype("null|null","[[any]]");
	}
	@Test public void test_1493() {
		checkNotSubtype("null|null","[[null]]");
	}
	@Test public void test_1494() {
		checkNotSubtype("null|null","[[int]]");
	}
	@Test public void test_1495() {
		checkNotSubtype("null|null","[!void]");
	}
	@Test public void test_1496() {
		checkNotSubtype("null|null","[!any]");
	}
	@Test public void test_1497() {
		checkNotSubtype("null|null","[!null]");
	}
	@Test public void test_1498() {
		checkNotSubtype("null|null","[!int]");
	}
	@Test public void test_1499() {
		checkIsSubtype("null|null","void|void");
	}
	@Test public void test_1500() {
		checkNotSubtype("null|null","void|any");
	}
	@Test public void test_1501() {
		checkIsSubtype("null|null","void|null");
	}
	@Test public void test_1502() {
		checkNotSubtype("null|null","void|int");
	}
	@Test public void test_1503() {
		checkNotSubtype("null|null","any|void");
	}
	@Test public void test_1504() {
		checkNotSubtype("null|null","any|any");
	}
	@Test public void test_1505() {
		checkNotSubtype("null|null","any|null");
	}
	@Test public void test_1506() {
		checkNotSubtype("null|null","any|int");
	}
	@Test public void test_1507() {
		checkIsSubtype("null|null","null|void");
	}
	@Test public void test_1508() {
		checkNotSubtype("null|null","null|any");
	}
	@Test public void test_1509() {
		checkIsSubtype("null|null","null|null");
	}
	@Test public void test_1510() {
		checkNotSubtype("null|null","null|int");
	}
	@Test public void test_1511() {
		checkNotSubtype("null|null","int|void");
	}
	@Test public void test_1512() {
		checkNotSubtype("null|null","int|any");
	}
	@Test public void test_1513() {
		checkNotSubtype("null|null","int|null");
	}
	@Test public void test_1514() {
		checkNotSubtype("null|null","int|int");
	}
	@Test public void test_1515() {
		checkNotSubtype("null|null","[void]|void");
	}
	@Test public void test_1516() {
		checkNotSubtype("null|null","[any]|any");
	}
	@Test public void test_1517() {
		checkNotSubtype("null|null","[null]|null");
	}
	@Test public void test_1518() {
		checkNotSubtype("null|null","[int]|int");
	}
	@Test public void test_1519() {
		checkNotSubtype("null|null","!void|void");
	}
	@Test public void test_1520() {
		checkNotSubtype("null|null","!any|any");
	}
	@Test public void test_1521() {
		checkNotSubtype("null|null","!null|null");
	}
	@Test public void test_1522() {
		checkNotSubtype("null|null","!int|int");
	}
	@Test public void test_1523() {
		checkNotSubtype("null|null","![void]");
	}
	@Test public void test_1524() {
		checkNotSubtype("null|null","![any]");
	}
	@Test public void test_1525() {
		checkNotSubtype("null|null","![null]");
	}
	@Test public void test_1526() {
		checkNotSubtype("null|null","![int]");
	}
	@Test public void test_1527() {
		checkIsSubtype("null|null","!!void");
	}
	@Test public void test_1528() {
		checkNotSubtype("null|null","!!any");
	}
	@Test public void test_1529() {
		checkIsSubtype("null|null","!!null");
	}
	@Test public void test_1530() {
		checkNotSubtype("null|null","!!int");
	}
	@Test public void test_1531() {
		checkNotSubtype("null|int","any");
	}
	@Test public void test_1532() {
		checkIsSubtype("null|int","null");
	}
	@Test public void test_1533() {
		checkIsSubtype("null|int","int");
	}
	@Test public void test_1534() {
		checkNotSubtype("null|int","[void]");
	}
	@Test public void test_1535() {
		checkNotSubtype("null|int","[any]");
	}
	@Test public void test_1536() {
		checkNotSubtype("null|int","[null]");
	}
	@Test public void test_1537() {
		checkNotSubtype("null|int","[int]");
	}
	@Test public void test_1538() {
		checkNotSubtype("null|int","!void");
	}
	@Test public void test_1539() {
		checkIsSubtype("null|int","!any");
	}
	@Test public void test_1540() {
		checkNotSubtype("null|int","!null");
	}
	@Test public void test_1541() {
		checkNotSubtype("null|int","!int");
	}
	@Test public void test_1542() {
		checkNotSubtype("null|int","[[void]]");
	}
	@Test public void test_1543() {
		checkNotSubtype("null|int","[[any]]");
	}
	@Test public void test_1544() {
		checkNotSubtype("null|int","[[null]]");
	}
	@Test public void test_1545() {
		checkNotSubtype("null|int","[[int]]");
	}
	@Test public void test_1546() {
		checkNotSubtype("null|int","[!void]");
	}
	@Test public void test_1547() {
		checkNotSubtype("null|int","[!any]");
	}
	@Test public void test_1548() {
		checkNotSubtype("null|int","[!null]");
	}
	@Test public void test_1549() {
		checkNotSubtype("null|int","[!int]");
	}
	@Test public void test_1550() {
		checkIsSubtype("null|int","void|void");
	}
	@Test public void test_1551() {
		checkNotSubtype("null|int","void|any");
	}
	@Test public void test_1552() {
		checkIsSubtype("null|int","void|null");
	}
	@Test public void test_1553() {
		checkIsSubtype("null|int","void|int");
	}
	@Test public void test_1554() {
		checkNotSubtype("null|int","any|void");
	}
	@Test public void test_1555() {
		checkNotSubtype("null|int","any|any");
	}
	@Test public void test_1556() {
		checkNotSubtype("null|int","any|null");
	}
	@Test public void test_1557() {
		checkNotSubtype("null|int","any|int");
	}
	@Test public void test_1558() {
		checkIsSubtype("null|int","null|void");
	}
	@Test public void test_1559() {
		checkNotSubtype("null|int","null|any");
	}
	@Test public void test_1560() {
		checkIsSubtype("null|int","null|null");
	}
	@Test public void test_1561() {
		checkIsSubtype("null|int","null|int");
	}
	@Test public void test_1562() {
		checkIsSubtype("null|int","int|void");
	}
	@Test public void test_1563() {
		checkNotSubtype("null|int","int|any");
	}
	@Test public void test_1564() {
		checkIsSubtype("null|int","int|null");
	}
	@Test public void test_1565() {
		checkIsSubtype("null|int","int|int");
	}
	@Test public void test_1566() {
		checkNotSubtype("null|int","[void]|void");
	}
	@Test public void test_1567() {
		checkNotSubtype("null|int","[any]|any");
	}
	@Test public void test_1568() {
		checkNotSubtype("null|int","[null]|null");
	}
	@Test public void test_1569() {
		checkNotSubtype("null|int","[int]|int");
	}
	@Test public void test_1570() {
		checkNotSubtype("null|int","!void|void");
	}
	@Test public void test_1571() {
		checkNotSubtype("null|int","!any|any");
	}
	@Test public void test_1572() {
		checkNotSubtype("null|int","!null|null");
	}
	@Test public void test_1573() {
		checkNotSubtype("null|int","!int|int");
	}
	@Test public void test_1574() {
		checkNotSubtype("null|int","![void]");
	}
	@Test public void test_1575() {
		checkNotSubtype("null|int","![any]");
	}
	@Test public void test_1576() {
		checkNotSubtype("null|int","![null]");
	}
	@Test public void test_1577() {
		checkNotSubtype("null|int","![int]");
	}
	@Test public void test_1578() {
		checkIsSubtype("null|int","!!void");
	}
	@Test public void test_1579() {
		checkNotSubtype("null|int","!!any");
	}
	@Test public void test_1580() {
		checkIsSubtype("null|int","!!null");
	}
	@Test public void test_1581() {
		checkIsSubtype("null|int","!!int");
	}
	@Test public void test_1582() {
		checkNotSubtype("int|void","any");
	}
	@Test public void test_1583() {
		checkNotSubtype("int|void","null");
	}
	@Test public void test_1584() {
		checkIsSubtype("int|void","int");
	}
	@Test public void test_1585() {
		checkNotSubtype("int|void","[void]");
	}
	@Test public void test_1586() {
		checkNotSubtype("int|void","[any]");
	}
	@Test public void test_1587() {
		checkNotSubtype("int|void","[null]");
	}
	@Test public void test_1588() {
		checkNotSubtype("int|void","[int]");
	}
	@Test public void test_1589() {
		checkNotSubtype("int|void","!void");
	}
	@Test public void test_1590() {
		checkIsSubtype("int|void","!any");
	}
	@Test public void test_1591() {
		checkNotSubtype("int|void","!null");
	}
	@Test public void test_1592() {
		checkNotSubtype("int|void","!int");
	}
	@Test public void test_1593() {
		checkNotSubtype("int|void","[[void]]");
	}
	@Test public void test_1594() {
		checkNotSubtype("int|void","[[any]]");
	}
	@Test public void test_1595() {
		checkNotSubtype("int|void","[[null]]");
	}
	@Test public void test_1596() {
		checkNotSubtype("int|void","[[int]]");
	}
	@Test public void test_1597() {
		checkNotSubtype("int|void","[!void]");
	}
	@Test public void test_1598() {
		checkNotSubtype("int|void","[!any]");
	}
	@Test public void test_1599() {
		checkNotSubtype("int|void","[!null]");
	}
	@Test public void test_1600() {
		checkNotSubtype("int|void","[!int]");
	}
	@Test public void test_1601() {
		checkIsSubtype("int|void","void|void");
	}
	@Test public void test_1602() {
		checkNotSubtype("int|void","void|any");
	}
	@Test public void test_1603() {
		checkNotSubtype("int|void","void|null");
	}
	@Test public void test_1604() {
		checkIsSubtype("int|void","void|int");
	}
	@Test public void test_1605() {
		checkNotSubtype("int|void","any|void");
	}
	@Test public void test_1606() {
		checkNotSubtype("int|void","any|any");
	}
	@Test public void test_1607() {
		checkNotSubtype("int|void","any|null");
	}
	@Test public void test_1608() {
		checkNotSubtype("int|void","any|int");
	}
	@Test public void test_1609() {
		checkNotSubtype("int|void","null|void");
	}
	@Test public void test_1610() {
		checkNotSubtype("int|void","null|any");
	}
	@Test public void test_1611() {
		checkNotSubtype("int|void","null|null");
	}
	@Test public void test_1612() {
		checkNotSubtype("int|void","null|int");
	}
	@Test public void test_1613() {
		checkIsSubtype("int|void","int|void");
	}
	@Test public void test_1614() {
		checkNotSubtype("int|void","int|any");
	}
	@Test public void test_1615() {
		checkNotSubtype("int|void","int|null");
	}
	@Test public void test_1616() {
		checkIsSubtype("int|void","int|int");
	}
	@Test public void test_1617() {
		checkNotSubtype("int|void","[void]|void");
	}
	@Test public void test_1618() {
		checkNotSubtype("int|void","[any]|any");
	}
	@Test public void test_1619() {
		checkNotSubtype("int|void","[null]|null");
	}
	@Test public void test_1620() {
		checkNotSubtype("int|void","[int]|int");
	}
	@Test public void test_1621() {
		checkNotSubtype("int|void","!void|void");
	}
	@Test public void test_1622() {
		checkNotSubtype("int|void","!any|any");
	}
	@Test public void test_1623() {
		checkNotSubtype("int|void","!null|null");
	}
	@Test public void test_1624() {
		checkNotSubtype("int|void","!int|int");
	}
	@Test public void test_1625() {
		checkNotSubtype("int|void","![void]");
	}
	@Test public void test_1626() {
		checkNotSubtype("int|void","![any]");
	}
	@Test public void test_1627() {
		checkNotSubtype("int|void","![null]");
	}
	@Test public void test_1628() {
		checkNotSubtype("int|void","![int]");
	}
	@Test public void test_1629() {
		checkIsSubtype("int|void","!!void");
	}
	@Test public void test_1630() {
		checkNotSubtype("int|void","!!any");
	}
	@Test public void test_1631() {
		checkNotSubtype("int|void","!!null");
	}
	@Test public void test_1632() {
		checkIsSubtype("int|void","!!int");
	}
	@Test public void test_1633() {
		checkIsSubtype("int|any","any");
	}
	@Test public void test_1634() {
		checkIsSubtype("int|any","null");
	}
	@Test public void test_1635() {
		checkIsSubtype("int|any","int");
	}
	@Test public void test_1636() {
		checkIsSubtype("int|any","[void]");
	}
	@Test public void test_1637() {
		checkIsSubtype("int|any","[any]");
	}
	@Test public void test_1638() {
		checkIsSubtype("int|any","[null]");
	}
	@Test public void test_1639() {
		checkIsSubtype("int|any","[int]");
	}
	@Test public void test_1640() {
		checkIsSubtype("int|any","!void");
	}
	@Test public void test_1641() {
		checkIsSubtype("int|any","!any");
	}
	@Test public void test_1642() {
		checkIsSubtype("int|any","!null");
	}
	@Test public void test_1643() {
		checkIsSubtype("int|any","!int");
	}
	@Test public void test_1644() {
		checkIsSubtype("int|any","[[void]]");
	}
	@Test public void test_1645() {
		checkIsSubtype("int|any","[[any]]");
	}
	@Test public void test_1646() {
		checkIsSubtype("int|any","[[null]]");
	}
	@Test public void test_1647() {
		checkIsSubtype("int|any","[[int]]");
	}
	@Test public void test_1648() {
		checkIsSubtype("int|any","[!void]");
	}
	@Test public void test_1649() {
		checkIsSubtype("int|any","[!any]");
	}
	@Test public void test_1650() {
		checkIsSubtype("int|any","[!null]");
	}
	@Test public void test_1651() {
		checkIsSubtype("int|any","[!int]");
	}
	@Test public void test_1652() {
		checkIsSubtype("int|any","void|void");
	}
	@Test public void test_1653() {
		checkIsSubtype("int|any","void|any");
	}
	@Test public void test_1654() {
		checkIsSubtype("int|any","void|null");
	}
	@Test public void test_1655() {
		checkIsSubtype("int|any","void|int");
	}
	@Test public void test_1656() {
		checkIsSubtype("int|any","any|void");
	}
	@Test public void test_1657() {
		checkIsSubtype("int|any","any|any");
	}
	@Test public void test_1658() {
		checkIsSubtype("int|any","any|null");
	}
	@Test public void test_1659() {
		checkIsSubtype("int|any","any|int");
	}
	@Test public void test_1660() {
		checkIsSubtype("int|any","null|void");
	}
	@Test public void test_1661() {
		checkIsSubtype("int|any","null|any");
	}
	@Test public void test_1662() {
		checkIsSubtype("int|any","null|null");
	}
	@Test public void test_1663() {
		checkIsSubtype("int|any","null|int");
	}
	@Test public void test_1664() {
		checkIsSubtype("int|any","int|void");
	}
	@Test public void test_1665() {
		checkIsSubtype("int|any","int|any");
	}
	@Test public void test_1666() {
		checkIsSubtype("int|any","int|null");
	}
	@Test public void test_1667() {
		checkIsSubtype("int|any","int|int");
	}
	@Test public void test_1668() {
		checkIsSubtype("int|any","[void]|void");
	}
	@Test public void test_1669() {
		checkIsSubtype("int|any","[any]|any");
	}
	@Test public void test_1670() {
		checkIsSubtype("int|any","[null]|null");
	}
	@Test public void test_1671() {
		checkIsSubtype("int|any","[int]|int");
	}
	@Test public void test_1672() {
		checkIsSubtype("int|any","!void|void");
	}
	@Test public void test_1673() {
		checkIsSubtype("int|any","!any|any");
	}
	@Test public void test_1674() {
		checkIsSubtype("int|any","!null|null");
	}
	@Test public void test_1675() {
		checkIsSubtype("int|any","!int|int");
	}
	@Test public void test_1676() {
		checkIsSubtype("int|any","![void]");
	}
	@Test public void test_1677() {
		checkIsSubtype("int|any","![any]");
	}
	@Test public void test_1678() {
		checkIsSubtype("int|any","![null]");
	}
	@Test public void test_1679() {
		checkIsSubtype("int|any","![int]");
	}
	@Test public void test_1680() {
		checkIsSubtype("int|any","!!void");
	}
	@Test public void test_1681() {
		checkIsSubtype("int|any","!!any");
	}
	@Test public void test_1682() {
		checkIsSubtype("int|any","!!null");
	}
	@Test public void test_1683() {
		checkIsSubtype("int|any","!!int");
	}
	@Test public void test_1684() {
		checkNotSubtype("int|null","any");
	}
	@Test public void test_1685() {
		checkIsSubtype("int|null","null");
	}
	@Test public void test_1686() {
		checkIsSubtype("int|null","int");
	}
	@Test public void test_1687() {
		checkNotSubtype("int|null","[void]");
	}
	@Test public void test_1688() {
		checkNotSubtype("int|null","[any]");
	}
	@Test public void test_1689() {
		checkNotSubtype("int|null","[null]");
	}
	@Test public void test_1690() {
		checkNotSubtype("int|null","[int]");
	}
	@Test public void test_1691() {
		checkNotSubtype("int|null","!void");
	}
	@Test public void test_1692() {
		checkIsSubtype("int|null","!any");
	}
	@Test public void test_1693() {
		checkNotSubtype("int|null","!null");
	}
	@Test public void test_1694() {
		checkNotSubtype("int|null","!int");
	}
	@Test public void test_1695() {
		checkNotSubtype("int|null","[[void]]");
	}
	@Test public void test_1696() {
		checkNotSubtype("int|null","[[any]]");
	}
	@Test public void test_1697() {
		checkNotSubtype("int|null","[[null]]");
	}
	@Test public void test_1698() {
		checkNotSubtype("int|null","[[int]]");
	}
	@Test public void test_1699() {
		checkNotSubtype("int|null","[!void]");
	}
	@Test public void test_1700() {
		checkNotSubtype("int|null","[!any]");
	}
	@Test public void test_1701() {
		checkNotSubtype("int|null","[!null]");
	}
	@Test public void test_1702() {
		checkNotSubtype("int|null","[!int]");
	}
	@Test public void test_1703() {
		checkIsSubtype("int|null","void|void");
	}
	@Test public void test_1704() {
		checkNotSubtype("int|null","void|any");
	}
	@Test public void test_1705() {
		checkIsSubtype("int|null","void|null");
	}
	@Test public void test_1706() {
		checkIsSubtype("int|null","void|int");
	}
	@Test public void test_1707() {
		checkNotSubtype("int|null","any|void");
	}
	@Test public void test_1708() {
		checkNotSubtype("int|null","any|any");
	}
	@Test public void test_1709() {
		checkNotSubtype("int|null","any|null");
	}
	@Test public void test_1710() {
		checkNotSubtype("int|null","any|int");
	}
	@Test public void test_1711() {
		checkIsSubtype("int|null","null|void");
	}
	@Test public void test_1712() {
		checkNotSubtype("int|null","null|any");
	}
	@Test public void test_1713() {
		checkIsSubtype("int|null","null|null");
	}
	@Test public void test_1714() {
		checkIsSubtype("int|null","null|int");
	}
	@Test public void test_1715() {
		checkIsSubtype("int|null","int|void");
	}
	@Test public void test_1716() {
		checkNotSubtype("int|null","int|any");
	}
	@Test public void test_1717() {
		checkIsSubtype("int|null","int|null");
	}
	@Test public void test_1718() {
		checkIsSubtype("int|null","int|int");
	}
	@Test public void test_1719() {
		checkNotSubtype("int|null","[void]|void");
	}
	@Test public void test_1720() {
		checkNotSubtype("int|null","[any]|any");
	}
	@Test public void test_1721() {
		checkNotSubtype("int|null","[null]|null");
	}
	@Test public void test_1722() {
		checkNotSubtype("int|null","[int]|int");
	}
	@Test public void test_1723() {
		checkNotSubtype("int|null","!void|void");
	}
	@Test public void test_1724() {
		checkNotSubtype("int|null","!any|any");
	}
	@Test public void test_1725() {
		checkNotSubtype("int|null","!null|null");
	}
	@Test public void test_1726() {
		checkNotSubtype("int|null","!int|int");
	}
	@Test public void test_1727() {
		checkNotSubtype("int|null","![void]");
	}
	@Test public void test_1728() {
		checkNotSubtype("int|null","![any]");
	}
	@Test public void test_1729() {
		checkNotSubtype("int|null","![null]");
	}
	@Test public void test_1730() {
		checkNotSubtype("int|null","![int]");
	}
	@Test public void test_1731() {
		checkIsSubtype("int|null","!!void");
	}
	@Test public void test_1732() {
		checkNotSubtype("int|null","!!any");
	}
	@Test public void test_1733() {
		checkIsSubtype("int|null","!!null");
	}
	@Test public void test_1734() {
		checkIsSubtype("int|null","!!int");
	}
	@Test public void test_1735() {
		checkNotSubtype("int|int","any");
	}
	@Test public void test_1736() {
		checkNotSubtype("int|int","null");
	}
	@Test public void test_1737() {
		checkIsSubtype("int|int","int");
	}
	@Test public void test_1738() {
		checkNotSubtype("int|int","[void]");
	}
	@Test public void test_1739() {
		checkNotSubtype("int|int","[any]");
	}
	@Test public void test_1740() {
		checkNotSubtype("int|int","[null]");
	}
	@Test public void test_1741() {
		checkNotSubtype("int|int","[int]");
	}
	@Test public void test_1742() {
		checkNotSubtype("int|int","!void");
	}
	@Test public void test_1743() {
		checkIsSubtype("int|int","!any");
	}
	@Test public void test_1744() {
		checkNotSubtype("int|int","!null");
	}
	@Test public void test_1745() {
		checkNotSubtype("int|int","!int");
	}
	@Test public void test_1746() {
		checkNotSubtype("int|int","[[void]]");
	}
	@Test public void test_1747() {
		checkNotSubtype("int|int","[[any]]");
	}
	@Test public void test_1748() {
		checkNotSubtype("int|int","[[null]]");
	}
	@Test public void test_1749() {
		checkNotSubtype("int|int","[[int]]");
	}
	@Test public void test_1750() {
		checkNotSubtype("int|int","[!void]");
	}
	@Test public void test_1751() {
		checkNotSubtype("int|int","[!any]");
	}
	@Test public void test_1752() {
		checkNotSubtype("int|int","[!null]");
	}
	@Test public void test_1753() {
		checkNotSubtype("int|int","[!int]");
	}
	@Test public void test_1754() {
		checkIsSubtype("int|int","void|void");
	}
	@Test public void test_1755() {
		checkNotSubtype("int|int","void|any");
	}
	@Test public void test_1756() {
		checkNotSubtype("int|int","void|null");
	}
	@Test public void test_1757() {
		checkIsSubtype("int|int","void|int");
	}
	@Test public void test_1758() {
		checkNotSubtype("int|int","any|void");
	}
	@Test public void test_1759() {
		checkNotSubtype("int|int","any|any");
	}
	@Test public void test_1760() {
		checkNotSubtype("int|int","any|null");
	}
	@Test public void test_1761() {
		checkNotSubtype("int|int","any|int");
	}
	@Test public void test_1762() {
		checkNotSubtype("int|int","null|void");
	}
	@Test public void test_1763() {
		checkNotSubtype("int|int","null|any");
	}
	@Test public void test_1764() {
		checkNotSubtype("int|int","null|null");
	}
	@Test public void test_1765() {
		checkNotSubtype("int|int","null|int");
	}
	@Test public void test_1766() {
		checkIsSubtype("int|int","int|void");
	}
	@Test public void test_1767() {
		checkNotSubtype("int|int","int|any");
	}
	@Test public void test_1768() {
		checkNotSubtype("int|int","int|null");
	}
	@Test public void test_1769() {
		checkIsSubtype("int|int","int|int");
	}
	@Test public void test_1770() {
		checkNotSubtype("int|int","[void]|void");
	}
	@Test public void test_1771() {
		checkNotSubtype("int|int","[any]|any");
	}
	@Test public void test_1772() {
		checkNotSubtype("int|int","[null]|null");
	}
	@Test public void test_1773() {
		checkNotSubtype("int|int","[int]|int");
	}
	@Test public void test_1774() {
		checkNotSubtype("int|int","!void|void");
	}
	@Test public void test_1775() {
		checkNotSubtype("int|int","!any|any");
	}
	@Test public void test_1776() {
		checkNotSubtype("int|int","!null|null");
	}
	@Test public void test_1777() {
		checkNotSubtype("int|int","!int|int");
	}
	@Test public void test_1778() {
		checkNotSubtype("int|int","![void]");
	}
	@Test public void test_1779() {
		checkNotSubtype("int|int","![any]");
	}
	@Test public void test_1780() {
		checkNotSubtype("int|int","![null]");
	}
	@Test public void test_1781() {
		checkNotSubtype("int|int","![int]");
	}
	@Test public void test_1782() {
		checkIsSubtype("int|int","!!void");
	}
	@Test public void test_1783() {
		checkNotSubtype("int|int","!!any");
	}
	@Test public void test_1784() {
		checkNotSubtype("int|int","!!null");
	}
	@Test public void test_1785() {
		checkIsSubtype("int|int","!!int");
	}
	@Test public void test_1786() {
		checkNotSubtype("[void]|void","any");
	}
	@Test public void test_1787() {
		checkNotSubtype("[void]|void","null");
	}
	@Test public void test_1788() {
		checkNotSubtype("[void]|void","int");
	}
	@Test public void test_1789() {
		checkIsSubtype("[void]|void","[void]");
	}
	@Test public void test_1790() {
		checkNotSubtype("[void]|void","[any]");
	}
	@Test public void test_1791() {
		checkNotSubtype("[void]|void","[null]");
	}
	@Test public void test_1792() {
		checkNotSubtype("[void]|void","[int]");
	}
	@Test public void test_1793() {
		checkNotSubtype("[void]|void","!void");
	}
	@Test public void test_1794() {
		checkIsSubtype("[void]|void","!any");
	}
	@Test public void test_1795() {
		checkNotSubtype("[void]|void","!null");
	}
	@Test public void test_1796() {
		checkNotSubtype("[void]|void","!int");
	}
	@Test public void test_1797() {
		checkNotSubtype("[void]|void","[[void]]");
	}
	@Test public void test_1798() {
		checkNotSubtype("[void]|void","[[any]]");
	}
	@Test public void test_1799() {
		checkNotSubtype("[void]|void","[[null]]");
	}
	@Test public void test_1800() {
		checkNotSubtype("[void]|void","[[int]]");
	}
	@Test public void test_1801() {
		checkNotSubtype("[void]|void","[!void]");
	}
	@Test public void test_1802() {
		checkIsSubtype("[void]|void","[!any]");
	}
	@Test public void test_1803() {
		checkNotSubtype("[void]|void","[!null]");
	}
	@Test public void test_1804() {
		checkNotSubtype("[void]|void","[!int]");
	}
	@Test public void test_1805() {
		checkIsSubtype("[void]|void","void|void");
	}
	@Test public void test_1806() {
		checkNotSubtype("[void]|void","void|any");
	}
	@Test public void test_1807() {
		checkNotSubtype("[void]|void","void|null");
	}
	@Test public void test_1808() {
		checkNotSubtype("[void]|void","void|int");
	}
	@Test public void test_1809() {
		checkNotSubtype("[void]|void","any|void");
	}
	@Test public void test_1810() {
		checkNotSubtype("[void]|void","any|any");
	}
	@Test public void test_1811() {
		checkNotSubtype("[void]|void","any|null");
	}
	@Test public void test_1812() {
		checkNotSubtype("[void]|void","any|int");
	}
	@Test public void test_1813() {
		checkNotSubtype("[void]|void","null|void");
	}
	@Test public void test_1814() {
		checkNotSubtype("[void]|void","null|any");
	}
	@Test public void test_1815() {
		checkNotSubtype("[void]|void","null|null");
	}
	@Test public void test_1816() {
		checkNotSubtype("[void]|void","null|int");
	}
	@Test public void test_1817() {
		checkNotSubtype("[void]|void","int|void");
	}
	@Test public void test_1818() {
		checkNotSubtype("[void]|void","int|any");
	}
	@Test public void test_1819() {
		checkNotSubtype("[void]|void","int|null");
	}
	@Test public void test_1820() {
		checkNotSubtype("[void]|void","int|int");
	}
	@Test public void test_1821() {
		checkIsSubtype("[void]|void","[void]|void");
	}
	@Test public void test_1822() {
		checkNotSubtype("[void]|void","[any]|any");
	}
	@Test public void test_1823() {
		checkNotSubtype("[void]|void","[null]|null");
	}
	@Test public void test_1824() {
		checkNotSubtype("[void]|void","[int]|int");
	}
	@Test public void test_1825() {
		checkNotSubtype("[void]|void","!void|void");
	}
	@Test public void test_1826() {
		checkNotSubtype("[void]|void","!any|any");
	}
	@Test public void test_1827() {
		checkNotSubtype("[void]|void","!null|null");
	}
	@Test public void test_1828() {
		checkNotSubtype("[void]|void","!int|int");
	}
	@Test public void test_1829() {
		checkNotSubtype("[void]|void","![void]");
	}
	@Test public void test_1830() {
		checkNotSubtype("[void]|void","![any]");
	}
	@Test public void test_1831() {
		checkNotSubtype("[void]|void","![null]");
	}
	@Test public void test_1832() {
		checkNotSubtype("[void]|void","![int]");
	}
	@Test public void test_1833() {
		checkIsSubtype("[void]|void","!!void");
	}
	@Test public void test_1834() {
		checkNotSubtype("[void]|void","!!any");
	}
	@Test public void test_1835() {
		checkNotSubtype("[void]|void","!!null");
	}
	@Test public void test_1836() {
		checkNotSubtype("[void]|void","!!int");
	}
	@Test public void test_1837() {
		checkIsSubtype("[any]|any","any");
	}
	@Test public void test_1838() {
		checkIsSubtype("[any]|any","null");
	}
	@Test public void test_1839() {
		checkIsSubtype("[any]|any","int");
	}
	@Test public void test_1840() {
		checkIsSubtype("[any]|any","[void]");
	}
	@Test public void test_1841() {
		checkIsSubtype("[any]|any","[any]");
	}
	@Test public void test_1842() {
		checkIsSubtype("[any]|any","[null]");
	}
	@Test public void test_1843() {
		checkIsSubtype("[any]|any","[int]");
	}
	@Test public void test_1844() {
		checkIsSubtype("[any]|any","!void");
	}
	@Test public void test_1845() {
		checkIsSubtype("[any]|any","!any");
	}
	@Test public void test_1846() {
		checkIsSubtype("[any]|any","!null");
	}
	@Test public void test_1847() {
		checkIsSubtype("[any]|any","!int");
	}
	@Test public void test_1848() {
		checkIsSubtype("[any]|any","[[void]]");
	}
	@Test public void test_1849() {
		checkIsSubtype("[any]|any","[[any]]");
	}
	@Test public void test_1850() {
		checkIsSubtype("[any]|any","[[null]]");
	}
	@Test public void test_1851() {
		checkIsSubtype("[any]|any","[[int]]");
	}
	@Test public void test_1852() {
		checkIsSubtype("[any]|any","[!void]");
	}
	@Test public void test_1853() {
		checkIsSubtype("[any]|any","[!any]");
	}
	@Test public void test_1854() {
		checkIsSubtype("[any]|any","[!null]");
	}
	@Test public void test_1855() {
		checkIsSubtype("[any]|any","[!int]");
	}
	@Test public void test_1856() {
		checkIsSubtype("[any]|any","void|void");
	}
	@Test public void test_1857() {
		checkIsSubtype("[any]|any","void|any");
	}
	@Test public void test_1858() {
		checkIsSubtype("[any]|any","void|null");
	}
	@Test public void test_1859() {
		checkIsSubtype("[any]|any","void|int");
	}
	@Test public void test_1860() {
		checkIsSubtype("[any]|any","any|void");
	}
	@Test public void test_1861() {
		checkIsSubtype("[any]|any","any|any");
	}
	@Test public void test_1862() {
		checkIsSubtype("[any]|any","any|null");
	}
	@Test public void test_1863() {
		checkIsSubtype("[any]|any","any|int");
	}
	@Test public void test_1864() {
		checkIsSubtype("[any]|any","null|void");
	}
	@Test public void test_1865() {
		checkIsSubtype("[any]|any","null|any");
	}
	@Test public void test_1866() {
		checkIsSubtype("[any]|any","null|null");
	}
	@Test public void test_1867() {
		checkIsSubtype("[any]|any","null|int");
	}
	@Test public void test_1868() {
		checkIsSubtype("[any]|any","int|void");
	}
	@Test public void test_1869() {
		checkIsSubtype("[any]|any","int|any");
	}
	@Test public void test_1870() {
		checkIsSubtype("[any]|any","int|null");
	}
	@Test public void test_1871() {
		checkIsSubtype("[any]|any","int|int");
	}
	@Test public void test_1872() {
		checkIsSubtype("[any]|any","[void]|void");
	}
	@Test public void test_1873() {
		checkIsSubtype("[any]|any","[any]|any");
	}
	@Test public void test_1874() {
		checkIsSubtype("[any]|any","[null]|null");
	}
	@Test public void test_1875() {
		checkIsSubtype("[any]|any","[int]|int");
	}
	@Test public void test_1876() {
		checkIsSubtype("[any]|any","!void|void");
	}
	@Test public void test_1877() {
		checkIsSubtype("[any]|any","!any|any");
	}
	@Test public void test_1878() {
		checkIsSubtype("[any]|any","!null|null");
	}
	@Test public void test_1879() {
		checkIsSubtype("[any]|any","!int|int");
	}
	@Test public void test_1880() {
		checkIsSubtype("[any]|any","![void]");
	}
	@Test public void test_1881() {
		checkIsSubtype("[any]|any","![any]");
	}
	@Test public void test_1882() {
		checkIsSubtype("[any]|any","![null]");
	}
	@Test public void test_1883() {
		checkIsSubtype("[any]|any","![int]");
	}
	@Test public void test_1884() {
		checkIsSubtype("[any]|any","!!void");
	}
	@Test public void test_1885() {
		checkIsSubtype("[any]|any","!!any");
	}
	@Test public void test_1886() {
		checkIsSubtype("[any]|any","!!null");
	}
	@Test public void test_1887() {
		checkIsSubtype("[any]|any","!!int");
	}
	@Test public void test_1888() {
		checkNotSubtype("[null]|null","any");
	}
	@Test public void test_1889() {
		checkIsSubtype("[null]|null","null");
	}
	@Test public void test_1890() {
		checkNotSubtype("[null]|null","int");
	}
	@Test public void test_1891() {
		checkIsSubtype("[null]|null","[void]");
	}
	@Test public void test_1892() {
		checkNotSubtype("[null]|null","[any]");
	}
	@Test public void test_1893() {
		checkIsSubtype("[null]|null","[null]");
	}
	@Test public void test_1894() {
		checkNotSubtype("[null]|null","[int]");
	}
	@Test public void test_1895() {
		checkNotSubtype("[null]|null","!void");
	}
	@Test public void test_1896() {
		checkIsSubtype("[null]|null","!any");
	}
	@Test public void test_1897() {
		checkNotSubtype("[null]|null","!null");
	}
	@Test public void test_1898() {
		checkNotSubtype("[null]|null","!int");
	}
	@Test public void test_1899() {
		checkNotSubtype("[null]|null","[[void]]");
	}
	@Test public void test_1900() {
		checkNotSubtype("[null]|null","[[any]]");
	}
	@Test public void test_1901() {
		checkNotSubtype("[null]|null","[[null]]");
	}
	@Test public void test_1902() {
		checkNotSubtype("[null]|null","[[int]]");
	}
	@Test public void test_1903() {
		checkNotSubtype("[null]|null","[!void]");
	}
	@Test public void test_1904() {
		checkIsSubtype("[null]|null","[!any]");
	}
	@Test public void test_1905() {
		checkNotSubtype("[null]|null","[!null]");
	}
	@Test public void test_1906() {
		checkNotSubtype("[null]|null","[!int]");
	}
	@Test public void test_1907() {
		checkIsSubtype("[null]|null","void|void");
	}
	@Test public void test_1908() {
		checkNotSubtype("[null]|null","void|any");
	}
	@Test public void test_1909() {
		checkIsSubtype("[null]|null","void|null");
	}
	@Test public void test_1910() {
		checkNotSubtype("[null]|null","void|int");
	}
	@Test public void test_1911() {
		checkNotSubtype("[null]|null","any|void");
	}
	@Test public void test_1912() {
		checkNotSubtype("[null]|null","any|any");
	}
	@Test public void test_1913() {
		checkNotSubtype("[null]|null","any|null");
	}
	@Test public void test_1914() {
		checkNotSubtype("[null]|null","any|int");
	}
	@Test public void test_1915() {
		checkIsSubtype("[null]|null","null|void");
	}
	@Test public void test_1916() {
		checkNotSubtype("[null]|null","null|any");
	}
	@Test public void test_1917() {
		checkIsSubtype("[null]|null","null|null");
	}
	@Test public void test_1918() {
		checkNotSubtype("[null]|null","null|int");
	}
	@Test public void test_1919() {
		checkNotSubtype("[null]|null","int|void");
	}
	@Test public void test_1920() {
		checkNotSubtype("[null]|null","int|any");
	}
	@Test public void test_1921() {
		checkNotSubtype("[null]|null","int|null");
	}
	@Test public void test_1922() {
		checkNotSubtype("[null]|null","int|int");
	}
	@Test public void test_1923() {
		checkIsSubtype("[null]|null","[void]|void");
	}
	@Test public void test_1924() {
		checkNotSubtype("[null]|null","[any]|any");
	}
	@Test public void test_1925() {
		checkIsSubtype("[null]|null","[null]|null");
	}
	@Test public void test_1926() {
		checkNotSubtype("[null]|null","[int]|int");
	}
	@Test public void test_1927() {
		checkNotSubtype("[null]|null","!void|void");
	}
	@Test public void test_1928() {
		checkNotSubtype("[null]|null","!any|any");
	}
	@Test public void test_1929() {
		checkNotSubtype("[null]|null","!null|null");
	}
	@Test public void test_1930() {
		checkNotSubtype("[null]|null","!int|int");
	}
	@Test public void test_1931() {
		checkNotSubtype("[null]|null","![void]");
	}
	@Test public void test_1932() {
		checkNotSubtype("[null]|null","![any]");
	}
	@Test public void test_1933() {
		checkNotSubtype("[null]|null","![null]");
	}
	@Test public void test_1934() {
		checkNotSubtype("[null]|null","![int]");
	}
	@Test public void test_1935() {
		checkIsSubtype("[null]|null","!!void");
	}
	@Test public void test_1936() {
		checkNotSubtype("[null]|null","!!any");
	}
	@Test public void test_1937() {
		checkIsSubtype("[null]|null","!!null");
	}
	@Test public void test_1938() {
		checkNotSubtype("[null]|null","!!int");
	}
	@Test public void test_1939() {
		checkNotSubtype("[int]|int","any");
	}
	@Test public void test_1940() {
		checkNotSubtype("[int]|int","null");
	}
	@Test public void test_1941() {
		checkIsSubtype("[int]|int","int");
	}
	@Test public void test_1942() {
		checkIsSubtype("[int]|int","[void]");
	}
	@Test public void test_1943() {
		checkNotSubtype("[int]|int","[any]");
	}
	@Test public void test_1944() {
		checkNotSubtype("[int]|int","[null]");
	}
	@Test public void test_1945() {
		checkIsSubtype("[int]|int","[int]");
	}
	@Test public void test_1946() {
		checkNotSubtype("[int]|int","!void");
	}
	@Test public void test_1947() {
		checkIsSubtype("[int]|int","!any");
	}
	@Test public void test_1948() {
		checkNotSubtype("[int]|int","!null");
	}
	@Test public void test_1949() {
		checkNotSubtype("[int]|int","!int");
	}
	@Test public void test_1950() {
		checkNotSubtype("[int]|int","[[void]]");
	}
	@Test public void test_1951() {
		checkNotSubtype("[int]|int","[[any]]");
	}
	@Test public void test_1952() {
		checkNotSubtype("[int]|int","[[null]]");
	}
	@Test public void test_1953() {
		checkNotSubtype("[int]|int","[[int]]");
	}
	@Test public void test_1954() {
		checkNotSubtype("[int]|int","[!void]");
	}
	@Test public void test_1955() {
		checkIsSubtype("[int]|int","[!any]");
	}
	@Test public void test_1956() {
		checkNotSubtype("[int]|int","[!null]");
	}
	@Test public void test_1957() {
		checkNotSubtype("[int]|int","[!int]");
	}
	@Test public void test_1958() {
		checkIsSubtype("[int]|int","void|void");
	}
	@Test public void test_1959() {
		checkNotSubtype("[int]|int","void|any");
	}
	@Test public void test_1960() {
		checkNotSubtype("[int]|int","void|null");
	}
	@Test public void test_1961() {
		checkIsSubtype("[int]|int","void|int");
	}
	@Test public void test_1962() {
		checkNotSubtype("[int]|int","any|void");
	}
	@Test public void test_1963() {
		checkNotSubtype("[int]|int","any|any");
	}
	@Test public void test_1964() {
		checkNotSubtype("[int]|int","any|null");
	}
	@Test public void test_1965() {
		checkNotSubtype("[int]|int","any|int");
	}
	@Test public void test_1966() {
		checkNotSubtype("[int]|int","null|void");
	}
	@Test public void test_1967() {
		checkNotSubtype("[int]|int","null|any");
	}
	@Test public void test_1968() {
		checkNotSubtype("[int]|int","null|null");
	}
	@Test public void test_1969() {
		checkNotSubtype("[int]|int","null|int");
	}
	@Test public void test_1970() {
		checkIsSubtype("[int]|int","int|void");
	}
	@Test public void test_1971() {
		checkNotSubtype("[int]|int","int|any");
	}
	@Test public void test_1972() {
		checkNotSubtype("[int]|int","int|null");
	}
	@Test public void test_1973() {
		checkIsSubtype("[int]|int","int|int");
	}
	@Test public void test_1974() {
		checkIsSubtype("[int]|int","[void]|void");
	}
	@Test public void test_1975() {
		checkNotSubtype("[int]|int","[any]|any");
	}
	@Test public void test_1976() {
		checkNotSubtype("[int]|int","[null]|null");
	}
	@Test public void test_1977() {
		checkIsSubtype("[int]|int","[int]|int");
	}
	@Test public void test_1978() {
		checkNotSubtype("[int]|int","!void|void");
	}
	@Test public void test_1979() {
		checkNotSubtype("[int]|int","!any|any");
	}
	@Test public void test_1980() {
		checkNotSubtype("[int]|int","!null|null");
	}
	@Test public void test_1981() {
		checkNotSubtype("[int]|int","!int|int");
	}
	@Test public void test_1982() {
		checkNotSubtype("[int]|int","![void]");
	}
	@Test public void test_1983() {
		checkNotSubtype("[int]|int","![any]");
	}
	@Test public void test_1984() {
		checkNotSubtype("[int]|int","![null]");
	}
	@Test public void test_1985() {
		checkNotSubtype("[int]|int","![int]");
	}
	@Test public void test_1986() {
		checkIsSubtype("[int]|int","!!void");
	}
	@Test public void test_1987() {
		checkNotSubtype("[int]|int","!!any");
	}
	@Test public void test_1988() {
		checkNotSubtype("[int]|int","!!null");
	}
	@Test public void test_1989() {
		checkIsSubtype("[int]|int","!!int");
	}
	@Test public void test_1990() {
		checkIsSubtype("!void|void","any");
	}
	@Test public void test_1991() {
		checkIsSubtype("!void|void","null");
	}
	@Test public void test_1992() {
		checkIsSubtype("!void|void","int");
	}
	@Test public void test_1993() {
		checkIsSubtype("!void|void","[void]");
	}
	@Test public void test_1994() {
		checkIsSubtype("!void|void","[any]");
	}
	@Test public void test_1995() {
		checkIsSubtype("!void|void","[null]");
	}
	@Test public void test_1996() {
		checkIsSubtype("!void|void","[int]");
	}
	@Test public void test_1997() {
		checkIsSubtype("!void|void","!void");
	}
	@Test public void test_1998() {
		checkIsSubtype("!void|void","!any");
	}
	@Test public void test_1999() {
		checkIsSubtype("!void|void","!null");
	}
	@Test public void test_2000() {
		checkIsSubtype("!void|void","!int");
	}
	@Test public void test_2001() {
		checkIsSubtype("!void|void","[[void]]");
	}
	@Test public void test_2002() {
		checkIsSubtype("!void|void","[[any]]");
	}
	@Test public void test_2003() {
		checkIsSubtype("!void|void","[[null]]");
	}
	@Test public void test_2004() {
		checkIsSubtype("!void|void","[[int]]");
	}
	@Test public void test_2005() {
		checkIsSubtype("!void|void","[!void]");
	}
	@Test public void test_2006() {
		checkIsSubtype("!void|void","[!any]");
	}
	@Test public void test_2007() {
		checkIsSubtype("!void|void","[!null]");
	}
	@Test public void test_2008() {
		checkIsSubtype("!void|void","[!int]");
	}
	@Test public void test_2009() {
		checkIsSubtype("!void|void","void|void");
	}
	@Test public void test_2010() {
		checkIsSubtype("!void|void","void|any");
	}
	@Test public void test_2011() {
		checkIsSubtype("!void|void","void|null");
	}
	@Test public void test_2012() {
		checkIsSubtype("!void|void","void|int");
	}
	@Test public void test_2013() {
		checkIsSubtype("!void|void","any|void");
	}
	@Test public void test_2014() {
		checkIsSubtype("!void|void","any|any");
	}
	@Test public void test_2015() {
		checkIsSubtype("!void|void","any|null");
	}
	@Test public void test_2016() {
		checkIsSubtype("!void|void","any|int");
	}
	@Test public void test_2017() {
		checkIsSubtype("!void|void","null|void");
	}
	@Test public void test_2018() {
		checkIsSubtype("!void|void","null|any");
	}
	@Test public void test_2019() {
		checkIsSubtype("!void|void","null|null");
	}
	@Test public void test_2020() {
		checkIsSubtype("!void|void","null|int");
	}
	@Test public void test_2021() {
		checkIsSubtype("!void|void","int|void");
	}
	@Test public void test_2022() {
		checkIsSubtype("!void|void","int|any");
	}
	@Test public void test_2023() {
		checkIsSubtype("!void|void","int|null");
	}
	@Test public void test_2024() {
		checkIsSubtype("!void|void","int|int");
	}
	@Test public void test_2025() {
		checkIsSubtype("!void|void","[void]|void");
	}
	@Test public void test_2026() {
		checkIsSubtype("!void|void","[any]|any");
	}
	@Test public void test_2027() {
		checkIsSubtype("!void|void","[null]|null");
	}
	@Test public void test_2028() {
		checkIsSubtype("!void|void","[int]|int");
	}
	@Test public void test_2029() {
		checkIsSubtype("!void|void","!void|void");
	}
	@Test public void test_2030() {
		checkIsSubtype("!void|void","!any|any");
	}
	@Test public void test_2031() {
		checkIsSubtype("!void|void","!null|null");
	}
	@Test public void test_2032() {
		checkIsSubtype("!void|void","!int|int");
	}
	@Test public void test_2033() {
		checkIsSubtype("!void|void","![void]");
	}
	@Test public void test_2034() {
		checkIsSubtype("!void|void","![any]");
	}
	@Test public void test_2035() {
		checkIsSubtype("!void|void","![null]");
	}
	@Test public void test_2036() {
		checkIsSubtype("!void|void","![int]");
	}
	@Test public void test_2037() {
		checkIsSubtype("!void|void","!!void");
	}
	@Test public void test_2038() {
		checkIsSubtype("!void|void","!!any");
	}
	@Test public void test_2039() {
		checkIsSubtype("!void|void","!!null");
	}
	@Test public void test_2040() {
		checkIsSubtype("!void|void","!!int");
	}
	@Test public void test_2041() {
		checkIsSubtype("!any|any","any");
	}
	@Test public void test_2042() {
		checkIsSubtype("!any|any","null");
	}
	@Test public void test_2043() {
		checkIsSubtype("!any|any","int");
	}
	@Test public void test_2044() {
		checkIsSubtype("!any|any","[void]");
	}
	@Test public void test_2045() {
		checkIsSubtype("!any|any","[any]");
	}
	@Test public void test_2046() {
		checkIsSubtype("!any|any","[null]");
	}
	@Test public void test_2047() {
		checkIsSubtype("!any|any","[int]");
	}
	@Test public void test_2048() {
		checkIsSubtype("!any|any","!void");
	}
	@Test public void test_2049() {
		checkIsSubtype("!any|any","!any");
	}
	@Test public void test_2050() {
		checkIsSubtype("!any|any","!null");
	}
	@Test public void test_2051() {
		checkIsSubtype("!any|any","!int");
	}
	@Test public void test_2052() {
		checkIsSubtype("!any|any","[[void]]");
	}
	@Test public void test_2053() {
		checkIsSubtype("!any|any","[[any]]");
	}
	@Test public void test_2054() {
		checkIsSubtype("!any|any","[[null]]");
	}
	@Test public void test_2055() {
		checkIsSubtype("!any|any","[[int]]");
	}
	@Test public void test_2056() {
		checkIsSubtype("!any|any","[!void]");
	}
	@Test public void test_2057() {
		checkIsSubtype("!any|any","[!any]");
	}
	@Test public void test_2058() {
		checkIsSubtype("!any|any","[!null]");
	}
	@Test public void test_2059() {
		checkIsSubtype("!any|any","[!int]");
	}
	@Test public void test_2060() {
		checkIsSubtype("!any|any","void|void");
	}
	@Test public void test_2061() {
		checkIsSubtype("!any|any","void|any");
	}
	@Test public void test_2062() {
		checkIsSubtype("!any|any","void|null");
	}
	@Test public void test_2063() {
		checkIsSubtype("!any|any","void|int");
	}
	@Test public void test_2064() {
		checkIsSubtype("!any|any","any|void");
	}
	@Test public void test_2065() {
		checkIsSubtype("!any|any","any|any");
	}
	@Test public void test_2066() {
		checkIsSubtype("!any|any","any|null");
	}
	@Test public void test_2067() {
		checkIsSubtype("!any|any","any|int");
	}
	@Test public void test_2068() {
		checkIsSubtype("!any|any","null|void");
	}
	@Test public void test_2069() {
		checkIsSubtype("!any|any","null|any");
	}
	@Test public void test_2070() {
		checkIsSubtype("!any|any","null|null");
	}
	@Test public void test_2071() {
		checkIsSubtype("!any|any","null|int");
	}
	@Test public void test_2072() {
		checkIsSubtype("!any|any","int|void");
	}
	@Test public void test_2073() {
		checkIsSubtype("!any|any","int|any");
	}
	@Test public void test_2074() {
		checkIsSubtype("!any|any","int|null");
	}
	@Test public void test_2075() {
		checkIsSubtype("!any|any","int|int");
	}
	@Test public void test_2076() {
		checkIsSubtype("!any|any","[void]|void");
	}
	@Test public void test_2077() {
		checkIsSubtype("!any|any","[any]|any");
	}
	@Test public void test_2078() {
		checkIsSubtype("!any|any","[null]|null");
	}
	@Test public void test_2079() {
		checkIsSubtype("!any|any","[int]|int");
	}
	@Test public void test_2080() {
		checkIsSubtype("!any|any","!void|void");
	}
	@Test public void test_2081() {
		checkIsSubtype("!any|any","!any|any");
	}
	@Test public void test_2082() {
		checkIsSubtype("!any|any","!null|null");
	}
	@Test public void test_2083() {
		checkIsSubtype("!any|any","!int|int");
	}
	@Test public void test_2084() {
		checkIsSubtype("!any|any","![void]");
	}
	@Test public void test_2085() {
		checkIsSubtype("!any|any","![any]");
	}
	@Test public void test_2086() {
		checkIsSubtype("!any|any","![null]");
	}
	@Test public void test_2087() {
		checkIsSubtype("!any|any","![int]");
	}
	@Test public void test_2088() {
		checkIsSubtype("!any|any","!!void");
	}
	@Test public void test_2089() {
		checkIsSubtype("!any|any","!!any");
	}
	@Test public void test_2090() {
		checkIsSubtype("!any|any","!!null");
	}
	@Test public void test_2091() {
		checkIsSubtype("!any|any","!!int");
	}
	@Test public void test_2092() {
		checkIsSubtype("!null|null","any");
	}
	@Test public void test_2093() {
		checkIsSubtype("!null|null","null");
	}
	@Test public void test_2094() {
		checkIsSubtype("!null|null","int");
	}
	@Test public void test_2095() {
		checkIsSubtype("!null|null","[void]");
	}
	@Test public void test_2096() {
		checkIsSubtype("!null|null","[any]");
	}
	@Test public void test_2097() {
		checkIsSubtype("!null|null","[null]");
	}
	@Test public void test_2098() {
		checkIsSubtype("!null|null","[int]");
	}
	@Test public void test_2099() {
		checkIsSubtype("!null|null","!void");
	}
	@Test public void test_2100() {
		checkIsSubtype("!null|null","!any");
	}
	@Test public void test_2101() {
		checkIsSubtype("!null|null","!null");
	}
	@Test public void test_2102() {
		checkIsSubtype("!null|null","!int");
	}
	@Test public void test_2103() {
		checkIsSubtype("!null|null","[[void]]");
	}
	@Test public void test_2104() {
		checkIsSubtype("!null|null","[[any]]");
	}
	@Test public void test_2105() {
		checkIsSubtype("!null|null","[[null]]");
	}
	@Test public void test_2106() {
		checkIsSubtype("!null|null","[[int]]");
	}
	@Test public void test_2107() {
		checkIsSubtype("!null|null","[!void]");
	}
	@Test public void test_2108() {
		checkIsSubtype("!null|null","[!any]");
	}
	@Test public void test_2109() {
		checkIsSubtype("!null|null","[!null]");
	}
	@Test public void test_2110() {
		checkIsSubtype("!null|null","[!int]");
	}
	@Test public void test_2111() {
		checkIsSubtype("!null|null","void|void");
	}
	@Test public void test_2112() {
		checkIsSubtype("!null|null","void|any");
	}
	@Test public void test_2113() {
		checkIsSubtype("!null|null","void|null");
	}
	@Test public void test_2114() {
		checkIsSubtype("!null|null","void|int");
	}
	@Test public void test_2115() {
		checkIsSubtype("!null|null","any|void");
	}
	@Test public void test_2116() {
		checkIsSubtype("!null|null","any|any");
	}
	@Test public void test_2117() {
		checkIsSubtype("!null|null","any|null");
	}
	@Test public void test_2118() {
		checkIsSubtype("!null|null","any|int");
	}
	@Test public void test_2119() {
		checkIsSubtype("!null|null","null|void");
	}
	@Test public void test_2120() {
		checkIsSubtype("!null|null","null|any");
	}
	@Test public void test_2121() {
		checkIsSubtype("!null|null","null|null");
	}
	@Test public void test_2122() {
		checkIsSubtype("!null|null","null|int");
	}
	@Test public void test_2123() {
		checkIsSubtype("!null|null","int|void");
	}
	@Test public void test_2124() {
		checkIsSubtype("!null|null","int|any");
	}
	@Test public void test_2125() {
		checkIsSubtype("!null|null","int|null");
	}
	@Test public void test_2126() {
		checkIsSubtype("!null|null","int|int");
	}
	@Test public void test_2127() {
		checkIsSubtype("!null|null","[void]|void");
	}
	@Test public void test_2128() {
		checkIsSubtype("!null|null","[any]|any");
	}
	@Test public void test_2129() {
		checkIsSubtype("!null|null","[null]|null");
	}
	@Test public void test_2130() {
		checkIsSubtype("!null|null","[int]|int");
	}
	@Test public void test_2131() {
		checkIsSubtype("!null|null","!void|void");
	}
	@Test public void test_2132() {
		checkIsSubtype("!null|null","!any|any");
	}
	@Test public void test_2133() {
		checkIsSubtype("!null|null","!null|null");
	}
	@Test public void test_2134() {
		checkIsSubtype("!null|null","!int|int");
	}
	@Test public void test_2135() {
		checkIsSubtype("!null|null","![void]");
	}
	@Test public void test_2136() {
		checkIsSubtype("!null|null","![any]");
	}
	@Test public void test_2137() {
		checkIsSubtype("!null|null","![null]");
	}
	@Test public void test_2138() {
		checkIsSubtype("!null|null","![int]");
	}
	@Test public void test_2139() {
		checkIsSubtype("!null|null","!!void");
	}
	@Test public void test_2140() {
		checkIsSubtype("!null|null","!!any");
	}
	@Test public void test_2141() {
		checkIsSubtype("!null|null","!!null");
	}
	@Test public void test_2142() {
		checkIsSubtype("!null|null","!!int");
	}
	@Test public void test_2143() {
		checkIsSubtype("!int|int","any");
	}
	@Test public void test_2144() {
		checkIsSubtype("!int|int","null");
	}
	@Test public void test_2145() {
		checkIsSubtype("!int|int","int");
	}
	@Test public void test_2146() {
		checkIsSubtype("!int|int","[void]");
	}
	@Test public void test_2147() {
		checkIsSubtype("!int|int","[any]");
	}
	@Test public void test_2148() {
		checkIsSubtype("!int|int","[null]");
	}
	@Test public void test_2149() {
		checkIsSubtype("!int|int","[int]");
	}
	@Test public void test_2150() {
		checkIsSubtype("!int|int","!void");
	}
	@Test public void test_2151() {
		checkIsSubtype("!int|int","!any");
	}
	@Test public void test_2152() {
		checkIsSubtype("!int|int","!null");
	}
	@Test public void test_2153() {
		checkIsSubtype("!int|int","!int");
	}
	@Test public void test_2154() {
		checkIsSubtype("!int|int","[[void]]");
	}
	@Test public void test_2155() {
		checkIsSubtype("!int|int","[[any]]");
	}
	@Test public void test_2156() {
		checkIsSubtype("!int|int","[[null]]");
	}
	@Test public void test_2157() {
		checkIsSubtype("!int|int","[[int]]");
	}
	@Test public void test_2158() {
		checkIsSubtype("!int|int","[!void]");
	}
	@Test public void test_2159() {
		checkIsSubtype("!int|int","[!any]");
	}
	@Test public void test_2160() {
		checkIsSubtype("!int|int","[!null]");
	}
	@Test public void test_2161() {
		checkIsSubtype("!int|int","[!int]");
	}
	@Test public void test_2162() {
		checkIsSubtype("!int|int","void|void");
	}
	@Test public void test_2163() {
		checkIsSubtype("!int|int","void|any");
	}
	@Test public void test_2164() {
		checkIsSubtype("!int|int","void|null");
	}
	@Test public void test_2165() {
		checkIsSubtype("!int|int","void|int");
	}
	@Test public void test_2166() {
		checkIsSubtype("!int|int","any|void");
	}
	@Test public void test_2167() {
		checkIsSubtype("!int|int","any|any");
	}
	@Test public void test_2168() {
		checkIsSubtype("!int|int","any|null");
	}
	@Test public void test_2169() {
		checkIsSubtype("!int|int","any|int");
	}
	@Test public void test_2170() {
		checkIsSubtype("!int|int","null|void");
	}
	@Test public void test_2171() {
		checkIsSubtype("!int|int","null|any");
	}
	@Test public void test_2172() {
		checkIsSubtype("!int|int","null|null");
	}
	@Test public void test_2173() {
		checkIsSubtype("!int|int","null|int");
	}
	@Test public void test_2174() {
		checkIsSubtype("!int|int","int|void");
	}
	@Test public void test_2175() {
		checkIsSubtype("!int|int","int|any");
	}
	@Test public void test_2176() {
		checkIsSubtype("!int|int","int|null");
	}
	@Test public void test_2177() {
		checkIsSubtype("!int|int","int|int");
	}
	@Test public void test_2178() {
		checkIsSubtype("!int|int","[void]|void");
	}
	@Test public void test_2179() {
		checkIsSubtype("!int|int","[any]|any");
	}
	@Test public void test_2180() {
		checkIsSubtype("!int|int","[null]|null");
	}
	@Test public void test_2181() {
		checkIsSubtype("!int|int","[int]|int");
	}
	@Test public void test_2182() {
		checkIsSubtype("!int|int","!void|void");
	}
	@Test public void test_2183() {
		checkIsSubtype("!int|int","!any|any");
	}
	@Test public void test_2184() {
		checkIsSubtype("!int|int","!null|null");
	}
	@Test public void test_2185() {
		checkIsSubtype("!int|int","!int|int");
	}
	@Test public void test_2186() {
		checkIsSubtype("!int|int","![void]");
	}
	@Test public void test_2187() {
		checkIsSubtype("!int|int","![any]");
	}
	@Test public void test_2188() {
		checkIsSubtype("!int|int","![null]");
	}
	@Test public void test_2189() {
		checkIsSubtype("!int|int","![int]");
	}
	@Test public void test_2190() {
		checkIsSubtype("!int|int","!!void");
	}
	@Test public void test_2191() {
		checkIsSubtype("!int|int","!!any");
	}
	@Test public void test_2192() {
		checkIsSubtype("!int|int","!!null");
	}
	@Test public void test_2193() {
		checkIsSubtype("!int|int","!!int");
	}
	@Test public void test_2194() {
		checkNotSubtype("![void]","any");
	}
	@Test public void test_2195() {
		checkIsSubtype("![void]","null");
	}
	@Test public void test_2196() {
		checkIsSubtype("![void]","int");
	}
	@Test public void test_2197() {
		checkNotSubtype("![void]","[void]");
	}
	@Test public void test_2198() {
		checkNotSubtype("![void]","[any]");
	}
	@Test public void test_2199() {
		checkNotSubtype("![void]","[null]");
	}
	@Test public void test_2200() {
		checkNotSubtype("![void]","[int]");
	}
	@Test public void test_2201() {
		checkNotSubtype("![void]","!void");
	}
	@Test public void test_2202() {
		checkIsSubtype("![void]","!any");
	}
	@Test public void test_2203() {
		checkNotSubtype("![void]","!null");
	}
	@Test public void test_2204() {
		checkNotSubtype("![void]","!int");
	}
	@Test public void test_2205() {
		checkNotSubtype("![void]","[[void]]");
	}
	@Test public void test_2206() {
		checkNotSubtype("![void]","[[any]]");
	}
	@Test public void test_2207() {
		checkNotSubtype("![void]","[[null]]");
	}
	@Test public void test_2208() {
		checkNotSubtype("![void]","[[int]]");
	}
	@Test public void test_2209() {
		checkNotSubtype("![void]","[!void]");
	}
	@Test public void test_2210() {
		checkNotSubtype("![void]","[!any]");
	}
	@Test public void test_2211() {
		checkNotSubtype("![void]","[!null]");
	}
	@Test public void test_2212() {
		checkNotSubtype("![void]","[!int]");
	}
	@Test public void test_2213() {
		checkIsSubtype("![void]","void|void");
	}
	@Test public void test_2214() {
		checkNotSubtype("![void]","void|any");
	}
	@Test public void test_2215() {
		checkIsSubtype("![void]","void|null");
	}
	@Test public void test_2216() {
		checkIsSubtype("![void]","void|int");
	}
	@Test public void test_2217() {
		checkNotSubtype("![void]","any|void");
	}
	@Test public void test_2218() {
		checkNotSubtype("![void]","any|any");
	}
	@Test public void test_2219() {
		checkNotSubtype("![void]","any|null");
	}
	@Test public void test_2220() {
		checkNotSubtype("![void]","any|int");
	}
	@Test public void test_2221() {
		checkIsSubtype("![void]","null|void");
	}
	@Test public void test_2222() {
		checkNotSubtype("![void]","null|any");
	}
	@Test public void test_2223() {
		checkIsSubtype("![void]","null|null");
	}
	@Test public void test_2224() {
		checkIsSubtype("![void]","null|int");
	}
	@Test public void test_2225() {
		checkIsSubtype("![void]","int|void");
	}
	@Test public void test_2226() {
		checkNotSubtype("![void]","int|any");
	}
	@Test public void test_2227() {
		checkIsSubtype("![void]","int|null");
	}
	@Test public void test_2228() {
		checkIsSubtype("![void]","int|int");
	}
	@Test public void test_2229() {
		checkNotSubtype("![void]","[void]|void");
	}
	@Test public void test_2230() {
		checkNotSubtype("![void]","[any]|any");
	}
	@Test public void test_2231() {
		checkNotSubtype("![void]","[null]|null");
	}
	@Test public void test_2232() {
		checkNotSubtype("![void]","[int]|int");
	}
	@Test public void test_2233() {
		checkNotSubtype("![void]","!void|void");
	}
	@Test public void test_2234() {
		checkNotSubtype("![void]","!any|any");
	}
	@Test public void test_2235() {
		checkNotSubtype("![void]","!null|null");
	}
	@Test public void test_2236() {
		checkNotSubtype("![void]","!int|int");
	}
	@Test public void test_2237() {
		checkIsSubtype("![void]","![void]");
	}
	@Test public void test_2238() {
		checkIsSubtype("![void]","![any]");
	}
	@Test public void test_2239() {
		checkIsSubtype("![void]","![null]");
	}
	@Test public void test_2240() {
		checkIsSubtype("![void]","![int]");
	}
	@Test public void test_2241() {
		checkIsSubtype("![void]","!!void");
	}
	@Test public void test_2242() {
		checkNotSubtype("![void]","!!any");
	}
	@Test public void test_2243() {
		checkIsSubtype("![void]","!!null");
	}
	@Test public void test_2244() {
		checkIsSubtype("![void]","!!int");
	}
	@Test public void test_2245() {
		checkNotSubtype("![any]","any");
	}
	@Test public void test_2246() {
		checkIsSubtype("![any]","null");
	}
	@Test public void test_2247() {
		checkIsSubtype("![any]","int");
	}
	@Test public void test_2248() {
		checkNotSubtype("![any]","[void]");
	}
	@Test public void test_2249() {
		checkNotSubtype("![any]","[any]");
	}
	@Test public void test_2250() {
		checkNotSubtype("![any]","[null]");
	}
	@Test public void test_2251() {
		checkNotSubtype("![any]","[int]");
	}
	@Test public void test_2252() {
		checkNotSubtype("![any]","!void");
	}
	@Test public void test_2253() {
		checkIsSubtype("![any]","!any");
	}
	@Test public void test_2254() {
		checkNotSubtype("![any]","!null");
	}
	@Test public void test_2255() {
		checkNotSubtype("![any]","!int");
	}
	@Test public void test_2256() {
		checkNotSubtype("![any]","[[void]]");
	}
	@Test public void test_2257() {
		checkNotSubtype("![any]","[[any]]");
	}
	@Test public void test_2258() {
		checkNotSubtype("![any]","[[null]]");
	}
	@Test public void test_2259() {
		checkNotSubtype("![any]","[[int]]");
	}
	@Test public void test_2260() {
		checkNotSubtype("![any]","[!void]");
	}
	@Test public void test_2261() {
		checkNotSubtype("![any]","[!any]");
	}
	@Test public void test_2262() {
		checkNotSubtype("![any]","[!null]");
	}
	@Test public void test_2263() {
		checkNotSubtype("![any]","[!int]");
	}
	@Test public void test_2264() {
		checkIsSubtype("![any]","void|void");
	}
	@Test public void test_2265() {
		checkNotSubtype("![any]","void|any");
	}
	@Test public void test_2266() {
		checkIsSubtype("![any]","void|null");
	}
	@Test public void test_2267() {
		checkIsSubtype("![any]","void|int");
	}
	@Test public void test_2268() {
		checkNotSubtype("![any]","any|void");
	}
	@Test public void test_2269() {
		checkNotSubtype("![any]","any|any");
	}
	@Test public void test_2270() {
		checkNotSubtype("![any]","any|null");
	}
	@Test public void test_2271() {
		checkNotSubtype("![any]","any|int");
	}
	@Test public void test_2272() {
		checkIsSubtype("![any]","null|void");
	}
	@Test public void test_2273() {
		checkNotSubtype("![any]","null|any");
	}
	@Test public void test_2274() {
		checkIsSubtype("![any]","null|null");
	}
	@Test public void test_2275() {
		checkIsSubtype("![any]","null|int");
	}
	@Test public void test_2276() {
		checkIsSubtype("![any]","int|void");
	}
	@Test public void test_2277() {
		checkNotSubtype("![any]","int|any");
	}
	@Test public void test_2278() {
		checkIsSubtype("![any]","int|null");
	}
	@Test public void test_2279() {
		checkIsSubtype("![any]","int|int");
	}
	@Test public void test_2280() {
		checkNotSubtype("![any]","[void]|void");
	}
	@Test public void test_2281() {
		checkNotSubtype("![any]","[any]|any");
	}
	@Test public void test_2282() {
		checkNotSubtype("![any]","[null]|null");
	}
	@Test public void test_2283() {
		checkNotSubtype("![any]","[int]|int");
	}
	@Test public void test_2284() {
		checkNotSubtype("![any]","!void|void");
	}
	@Test public void test_2285() {
		checkNotSubtype("![any]","!any|any");
	}
	@Test public void test_2286() {
		checkNotSubtype("![any]","!null|null");
	}
	@Test public void test_2287() {
		checkNotSubtype("![any]","!int|int");
	}
	@Test public void test_2288() {
		checkNotSubtype("![any]","![void]");
	}
	@Test public void test_2289() {
		checkIsSubtype("![any]","![any]");
	}
	@Test public void test_2290() {
		checkNotSubtype("![any]","![null]");
	}
	@Test public void test_2291() {
		checkNotSubtype("![any]","![int]");
	}
	@Test public void test_2292() {
		checkIsSubtype("![any]","!!void");
	}
	@Test public void test_2293() {
		checkNotSubtype("![any]","!!any");
	}
	@Test public void test_2294() {
		checkIsSubtype("![any]","!!null");
	}
	@Test public void test_2295() {
		checkIsSubtype("![any]","!!int");
	}
	@Test public void test_2296() {
		checkNotSubtype("![null]","any");
	}
	@Test public void test_2297() {
		checkIsSubtype("![null]","null");
	}
	@Test public void test_2298() {
		checkIsSubtype("![null]","int");
	}
	@Test public void test_2299() {
		checkNotSubtype("![null]","[void]");
	}
	@Test public void test_2300() {
		checkNotSubtype("![null]","[any]");
	}
	@Test public void test_2301() {
		checkNotSubtype("![null]","[null]");
	}
	@Test public void test_2302() {
		checkNotSubtype("![null]","[int]");
	}
	@Test public void test_2303() {
		checkNotSubtype("![null]","!void");
	}
	@Test public void test_2304() {
		checkIsSubtype("![null]","!any");
	}
	@Test public void test_2305() {
		checkNotSubtype("![null]","!null");
	}
	@Test public void test_2306() {
		checkNotSubtype("![null]","!int");
	}
	@Test public void test_2307() {
		checkNotSubtype("![null]","[[void]]");
	}
	@Test public void test_2308() {
		checkNotSubtype("![null]","[[any]]");
	}
	@Test public void test_2309() {
		checkNotSubtype("![null]","[[null]]");
	}
	@Test public void test_2310() {
		checkNotSubtype("![null]","[[int]]");
	}
	@Test public void test_2311() {
		checkNotSubtype("![null]","[!void]");
	}
	@Test public void test_2312() {
		checkNotSubtype("![null]","[!any]");
	}
	@Test public void test_2313() {
		checkNotSubtype("![null]","[!null]");
	}
	@Test public void test_2314() {
		checkNotSubtype("![null]","[!int]");
	}
	@Test public void test_2315() {
		checkIsSubtype("![null]","void|void");
	}
	@Test public void test_2316() {
		checkNotSubtype("![null]","void|any");
	}
	@Test public void test_2317() {
		checkIsSubtype("![null]","void|null");
	}
	@Test public void test_2318() {
		checkIsSubtype("![null]","void|int");
	}
	@Test public void test_2319() {
		checkNotSubtype("![null]","any|void");
	}
	@Test public void test_2320() {
		checkNotSubtype("![null]","any|any");
	}
	@Test public void test_2321() {
		checkNotSubtype("![null]","any|null");
	}
	@Test public void test_2322() {
		checkNotSubtype("![null]","any|int");
	}
	@Test public void test_2323() {
		checkIsSubtype("![null]","null|void");
	}
	@Test public void test_2324() {
		checkNotSubtype("![null]","null|any");
	}
	@Test public void test_2325() {
		checkIsSubtype("![null]","null|null");
	}
	@Test public void test_2326() {
		checkIsSubtype("![null]","null|int");
	}
	@Test public void test_2327() {
		checkIsSubtype("![null]","int|void");
	}
	@Test public void test_2328() {
		checkNotSubtype("![null]","int|any");
	}
	@Test public void test_2329() {
		checkIsSubtype("![null]","int|null");
	}
	@Test public void test_2330() {
		checkIsSubtype("![null]","int|int");
	}
	@Test public void test_2331() {
		checkNotSubtype("![null]","[void]|void");
	}
	@Test public void test_2332() {
		checkNotSubtype("![null]","[any]|any");
	}
	@Test public void test_2333() {
		checkNotSubtype("![null]","[null]|null");
	}
	@Test public void test_2334() {
		checkNotSubtype("![null]","[int]|int");
	}
	@Test public void test_2335() {
		checkNotSubtype("![null]","!void|void");
	}
	@Test public void test_2336() {
		checkNotSubtype("![null]","!any|any");
	}
	@Test public void test_2337() {
		checkNotSubtype("![null]","!null|null");
	}
	@Test public void test_2338() {
		checkNotSubtype("![null]","!int|int");
	}
	@Test public void test_2339() {
		checkNotSubtype("![null]","![void]");
	}
	@Test public void test_2340() {
		checkIsSubtype("![null]","![any]");
	}
	@Test public void test_2341() {
		checkIsSubtype("![null]","![null]");
	}
	@Test public void test_2342() {
		checkNotSubtype("![null]","![int]");
	}
	@Test public void test_2343() {
		checkIsSubtype("![null]","!!void");
	}
	@Test public void test_2344() {
		checkNotSubtype("![null]","!!any");
	}
	@Test public void test_2345() {
		checkIsSubtype("![null]","!!null");
	}
	@Test public void test_2346() {
		checkIsSubtype("![null]","!!int");
	}
	@Test public void test_2347() {
		checkNotSubtype("![int]","any");
	}
	@Test public void test_2348() {
		checkIsSubtype("![int]","null");
	}
	@Test public void test_2349() {
		checkIsSubtype("![int]","int");
	}
	@Test public void test_2350() {
		checkNotSubtype("![int]","[void]");
	}
	@Test public void test_2351() {
		checkNotSubtype("![int]","[any]");
	}
	@Test public void test_2352() {
		checkNotSubtype("![int]","[null]");
	}
	@Test public void test_2353() {
		checkNotSubtype("![int]","[int]");
	}
	@Test public void test_2354() {
		checkNotSubtype("![int]","!void");
	}
	@Test public void test_2355() {
		checkIsSubtype("![int]","!any");
	}
	@Test public void test_2356() {
		checkNotSubtype("![int]","!null");
	}
	@Test public void test_2357() {
		checkNotSubtype("![int]","!int");
	}
	@Test public void test_2358() {
		checkNotSubtype("![int]","[[void]]");
	}
	@Test public void test_2359() {
		checkNotSubtype("![int]","[[any]]");
	}
	@Test public void test_2360() {
		checkNotSubtype("![int]","[[null]]");
	}
	@Test public void test_2361() {
		checkNotSubtype("![int]","[[int]]");
	}
	@Test public void test_2362() {
		checkNotSubtype("![int]","[!void]");
	}
	@Test public void test_2363() {
		checkNotSubtype("![int]","[!any]");
	}
	@Test public void test_2364() {
		checkNotSubtype("![int]","[!null]");
	}
	@Test public void test_2365() {
		checkNotSubtype("![int]","[!int]");
	}
	@Test public void test_2366() {
		checkIsSubtype("![int]","void|void");
	}
	@Test public void test_2367() {
		checkNotSubtype("![int]","void|any");
	}
	@Test public void test_2368() {
		checkIsSubtype("![int]","void|null");
	}
	@Test public void test_2369() {
		checkIsSubtype("![int]","void|int");
	}
	@Test public void test_2370() {
		checkNotSubtype("![int]","any|void");
	}
	@Test public void test_2371() {
		checkNotSubtype("![int]","any|any");
	}
	@Test public void test_2372() {
		checkNotSubtype("![int]","any|null");
	}
	@Test public void test_2373() {
		checkNotSubtype("![int]","any|int");
	}
	@Test public void test_2374() {
		checkIsSubtype("![int]","null|void");
	}
	@Test public void test_2375() {
		checkNotSubtype("![int]","null|any");
	}
	@Test public void test_2376() {
		checkIsSubtype("![int]","null|null");
	}
	@Test public void test_2377() {
		checkIsSubtype("![int]","null|int");
	}
	@Test public void test_2378() {
		checkIsSubtype("![int]","int|void");
	}
	@Test public void test_2379() {
		checkNotSubtype("![int]","int|any");
	}
	@Test public void test_2380() {
		checkIsSubtype("![int]","int|null");
	}
	@Test public void test_2381() {
		checkIsSubtype("![int]","int|int");
	}
	@Test public void test_2382() {
		checkNotSubtype("![int]","[void]|void");
	}
	@Test public void test_2383() {
		checkNotSubtype("![int]","[any]|any");
	}
	@Test public void test_2384() {
		checkNotSubtype("![int]","[null]|null");
	}
	@Test public void test_2385() {
		checkNotSubtype("![int]","[int]|int");
	}
	@Test public void test_2386() {
		checkNotSubtype("![int]","!void|void");
	}
	@Test public void test_2387() {
		checkNotSubtype("![int]","!any|any");
	}
	@Test public void test_2388() {
		checkNotSubtype("![int]","!null|null");
	}
	@Test public void test_2389() {
		checkNotSubtype("![int]","!int|int");
	}
	@Test public void test_2390() {
		checkNotSubtype("![int]","![void]");
	}
	@Test public void test_2391() {
		checkIsSubtype("![int]","![any]");
	}
	@Test public void test_2392() {
		checkNotSubtype("![int]","![null]");
	}
	@Test public void test_2393() {
		checkIsSubtype("![int]","![int]");
	}
	@Test public void test_2394() {
		checkIsSubtype("![int]","!!void");
	}
	@Test public void test_2395() {
		checkNotSubtype("![int]","!!any");
	}
	@Test public void test_2396() {
		checkIsSubtype("![int]","!!null");
	}
	@Test public void test_2397() {
		checkIsSubtype("![int]","!!int");
	}
	@Test public void test_2398() {
		checkNotSubtype("!!void","any");
	}
	@Test public void test_2399() {
		checkNotSubtype("!!void","null");
	}
	@Test public void test_2400() {
		checkNotSubtype("!!void","int");
	}
	@Test public void test_2401() {
		checkNotSubtype("!!void","[void]");
	}
	@Test public void test_2402() {
		checkNotSubtype("!!void","[any]");
	}
	@Test public void test_2403() {
		checkNotSubtype("!!void","[null]");
	}
	@Test public void test_2404() {
		checkNotSubtype("!!void","[int]");
	}
	@Test public void test_2405() {
		checkNotSubtype("!!void","!void");
	}
	@Test public void test_2406() {
		checkIsSubtype("!!void","!any");
	}
	@Test public void test_2407() {
		checkNotSubtype("!!void","!null");
	}
	@Test public void test_2408() {
		checkNotSubtype("!!void","!int");
	}
	@Test public void test_2409() {
		checkNotSubtype("!!void","[[void]]");
	}
	@Test public void test_2410() {
		checkNotSubtype("!!void","[[any]]");
	}
	@Test public void test_2411() {
		checkNotSubtype("!!void","[[null]]");
	}
	@Test public void test_2412() {
		checkNotSubtype("!!void","[[int]]");
	}
	@Test public void test_2413() {
		checkNotSubtype("!!void","[!void]");
	}
	@Test public void test_2414() {
		checkNotSubtype("!!void","[!any]");
	}
	@Test public void test_2415() {
		checkNotSubtype("!!void","[!null]");
	}
	@Test public void test_2416() {
		checkNotSubtype("!!void","[!int]");
	}
	@Test public void test_2417() {
		checkIsSubtype("!!void","void|void");
	}
	@Test public void test_2418() {
		checkNotSubtype("!!void","void|any");
	}
	@Test public void test_2419() {
		checkNotSubtype("!!void","void|null");
	}
	@Test public void test_2420() {
		checkNotSubtype("!!void","void|int");
	}
	@Test public void test_2421() {
		checkNotSubtype("!!void","any|void");
	}
	@Test public void test_2422() {
		checkNotSubtype("!!void","any|any");
	}
	@Test public void test_2423() {
		checkNotSubtype("!!void","any|null");
	}
	@Test public void test_2424() {
		checkNotSubtype("!!void","any|int");
	}
	@Test public void test_2425() {
		checkNotSubtype("!!void","null|void");
	}
	@Test public void test_2426() {
		checkNotSubtype("!!void","null|any");
	}
	@Test public void test_2427() {
		checkNotSubtype("!!void","null|null");
	}
	@Test public void test_2428() {
		checkNotSubtype("!!void","null|int");
	}
	@Test public void test_2429() {
		checkNotSubtype("!!void","int|void");
	}
	@Test public void test_2430() {
		checkNotSubtype("!!void","int|any");
	}
	@Test public void test_2431() {
		checkNotSubtype("!!void","int|null");
	}
	@Test public void test_2432() {
		checkNotSubtype("!!void","int|int");
	}
	@Test public void test_2433() {
		checkNotSubtype("!!void","[void]|void");
	}
	@Test public void test_2434() {
		checkNotSubtype("!!void","[any]|any");
	}
	@Test public void test_2435() {
		checkNotSubtype("!!void","[null]|null");
	}
	@Test public void test_2436() {
		checkNotSubtype("!!void","[int]|int");
	}
	@Test public void test_2437() {
		checkNotSubtype("!!void","!void|void");
	}
	@Test public void test_2438() {
		checkNotSubtype("!!void","!any|any");
	}
	@Test public void test_2439() {
		checkNotSubtype("!!void","!null|null");
	}
	@Test public void test_2440() {
		checkNotSubtype("!!void","!int|int");
	}
	@Test public void test_2441() {
		checkNotSubtype("!!void","![void]");
	}
	@Test public void test_2442() {
		checkNotSubtype("!!void","![any]");
	}
	@Test public void test_2443() {
		checkNotSubtype("!!void","![null]");
	}
	@Test public void test_2444() {
		checkNotSubtype("!!void","![int]");
	}
	@Test public void test_2445() {
		checkIsSubtype("!!void","!!void");
	}
	@Test public void test_2446() {
		checkNotSubtype("!!void","!!any");
	}
	@Test public void test_2447() {
		checkNotSubtype("!!void","!!null");
	}
	@Test public void test_2448() {
		checkNotSubtype("!!void","!!int");
	}
	@Test public void test_2449() {
		checkIsSubtype("!!any","any");
	}
	@Test public void test_2450() {
		checkIsSubtype("!!any","null");
	}
	@Test public void test_2451() {
		checkIsSubtype("!!any","int");
	}
	@Test public void test_2452() {
		checkIsSubtype("!!any","[void]");
	}
	@Test public void test_2453() {
		checkIsSubtype("!!any","[any]");
	}
	@Test public void test_2454() {
		checkIsSubtype("!!any","[null]");
	}
	@Test public void test_2455() {
		checkIsSubtype("!!any","[int]");
	}
	@Test public void test_2456() {
		checkIsSubtype("!!any","!void");
	}
	@Test public void test_2457() {
		checkIsSubtype("!!any","!any");
	}
	@Test public void test_2458() {
		checkIsSubtype("!!any","!null");
	}
	@Test public void test_2459() {
		checkIsSubtype("!!any","!int");
	}
	@Test public void test_2460() {
		checkIsSubtype("!!any","[[void]]");
	}
	@Test public void test_2461() {
		checkIsSubtype("!!any","[[any]]");
	}
	@Test public void test_2462() {
		checkIsSubtype("!!any","[[null]]");
	}
	@Test public void test_2463() {
		checkIsSubtype("!!any","[[int]]");
	}
	@Test public void test_2464() {
		checkIsSubtype("!!any","[!void]");
	}
	@Test public void test_2465() {
		checkIsSubtype("!!any","[!any]");
	}
	@Test public void test_2466() {
		checkIsSubtype("!!any","[!null]");
	}
	@Test public void test_2467() {
		checkIsSubtype("!!any","[!int]");
	}
	@Test public void test_2468() {
		checkIsSubtype("!!any","void|void");
	}
	@Test public void test_2469() {
		checkIsSubtype("!!any","void|any");
	}
	@Test public void test_2470() {
		checkIsSubtype("!!any","void|null");
	}
	@Test public void test_2471() {
		checkIsSubtype("!!any","void|int");
	}
	@Test public void test_2472() {
		checkIsSubtype("!!any","any|void");
	}
	@Test public void test_2473() {
		checkIsSubtype("!!any","any|any");
	}
	@Test public void test_2474() {
		checkIsSubtype("!!any","any|null");
	}
	@Test public void test_2475() {
		checkIsSubtype("!!any","any|int");
	}
	@Test public void test_2476() {
		checkIsSubtype("!!any","null|void");
	}
	@Test public void test_2477() {
		checkIsSubtype("!!any","null|any");
	}
	@Test public void test_2478() {
		checkIsSubtype("!!any","null|null");
	}
	@Test public void test_2479() {
		checkIsSubtype("!!any","null|int");
	}
	@Test public void test_2480() {
		checkIsSubtype("!!any","int|void");
	}
	@Test public void test_2481() {
		checkIsSubtype("!!any","int|any");
	}
	@Test public void test_2482() {
		checkIsSubtype("!!any","int|null");
	}
	@Test public void test_2483() {
		checkIsSubtype("!!any","int|int");
	}
	@Test public void test_2484() {
		checkIsSubtype("!!any","[void]|void");
	}
	@Test public void test_2485() {
		checkIsSubtype("!!any","[any]|any");
	}
	@Test public void test_2486() {
		checkIsSubtype("!!any","[null]|null");
	}
	@Test public void test_2487() {
		checkIsSubtype("!!any","[int]|int");
	}
	@Test public void test_2488() {
		checkIsSubtype("!!any","!void|void");
	}
	@Test public void test_2489() {
		checkIsSubtype("!!any","!any|any");
	}
	@Test public void test_2490() {
		checkIsSubtype("!!any","!null|null");
	}
	@Test public void test_2491() {
		checkIsSubtype("!!any","!int|int");
	}
	@Test public void test_2492() {
		checkIsSubtype("!!any","![void]");
	}
	@Test public void test_2493() {
		checkIsSubtype("!!any","![any]");
	}
	@Test public void test_2494() {
		checkIsSubtype("!!any","![null]");
	}
	@Test public void test_2495() {
		checkIsSubtype("!!any","![int]");
	}
	@Test public void test_2496() {
		checkIsSubtype("!!any","!!void");
	}
	@Test public void test_2497() {
		checkIsSubtype("!!any","!!any");
	}
	@Test public void test_2498() {
		checkIsSubtype("!!any","!!null");
	}
	@Test public void test_2499() {
		checkIsSubtype("!!any","!!int");
	}
	@Test public void test_2500() {
		checkNotSubtype("!!null","any");
	}
	@Test public void test_2501() {
		checkIsSubtype("!!null","null");
	}
	@Test public void test_2502() {
		checkNotSubtype("!!null","int");
	}
	@Test public void test_2503() {
		checkNotSubtype("!!null","[void]");
	}
	@Test public void test_2504() {
		checkNotSubtype("!!null","[any]");
	}
	@Test public void test_2505() {
		checkNotSubtype("!!null","[null]");
	}
	@Test public void test_2506() {
		checkNotSubtype("!!null","[int]");
	}
	@Test public void test_2507() {
		checkNotSubtype("!!null","!void");
	}
	@Test public void test_2508() {
		checkIsSubtype("!!null","!any");
	}
	@Test public void test_2509() {
		checkNotSubtype("!!null","!null");
	}
	@Test public void test_2510() {
		checkNotSubtype("!!null","!int");
	}
	@Test public void test_2511() {
		checkNotSubtype("!!null","[[void]]");
	}
	@Test public void test_2512() {
		checkNotSubtype("!!null","[[any]]");
	}
	@Test public void test_2513() {
		checkNotSubtype("!!null","[[null]]");
	}
	@Test public void test_2514() {
		checkNotSubtype("!!null","[[int]]");
	}
	@Test public void test_2515() {
		checkNotSubtype("!!null","[!void]");
	}
	@Test public void test_2516() {
		checkNotSubtype("!!null","[!any]");
	}
	@Test public void test_2517() {
		checkNotSubtype("!!null","[!null]");
	}
	@Test public void test_2518() {
		checkNotSubtype("!!null","[!int]");
	}
	@Test public void test_2519() {
		checkIsSubtype("!!null","void|void");
	}
	@Test public void test_2520() {
		checkNotSubtype("!!null","void|any");
	}
	@Test public void test_2521() {
		checkIsSubtype("!!null","void|null");
	}
	@Test public void test_2522() {
		checkNotSubtype("!!null","void|int");
	}
	@Test public void test_2523() {
		checkNotSubtype("!!null","any|void");
	}
	@Test public void test_2524() {
		checkNotSubtype("!!null","any|any");
	}
	@Test public void test_2525() {
		checkNotSubtype("!!null","any|null");
	}
	@Test public void test_2526() {
		checkNotSubtype("!!null","any|int");
	}
	@Test public void test_2527() {
		checkIsSubtype("!!null","null|void");
	}
	@Test public void test_2528() {
		checkNotSubtype("!!null","null|any");
	}
	@Test public void test_2529() {
		checkIsSubtype("!!null","null|null");
	}
	@Test public void test_2530() {
		checkNotSubtype("!!null","null|int");
	}
	@Test public void test_2531() {
		checkNotSubtype("!!null","int|void");
	}
	@Test public void test_2532() {
		checkNotSubtype("!!null","int|any");
	}
	@Test public void test_2533() {
		checkNotSubtype("!!null","int|null");
	}
	@Test public void test_2534() {
		checkNotSubtype("!!null","int|int");
	}
	@Test public void test_2535() {
		checkNotSubtype("!!null","[void]|void");
	}
	@Test public void test_2536() {
		checkNotSubtype("!!null","[any]|any");
	}
	@Test public void test_2537() {
		checkNotSubtype("!!null","[null]|null");
	}
	@Test public void test_2538() {
		checkNotSubtype("!!null","[int]|int");
	}
	@Test public void test_2539() {
		checkNotSubtype("!!null","!void|void");
	}
	@Test public void test_2540() {
		checkNotSubtype("!!null","!any|any");
	}
	@Test public void test_2541() {
		checkNotSubtype("!!null","!null|null");
	}
	@Test public void test_2542() {
		checkNotSubtype("!!null","!int|int");
	}
	@Test public void test_2543() {
		checkNotSubtype("!!null","![void]");
	}
	@Test public void test_2544() {
		checkNotSubtype("!!null","![any]");
	}
	@Test public void test_2545() {
		checkNotSubtype("!!null","![null]");
	}
	@Test public void test_2546() {
		checkNotSubtype("!!null","![int]");
	}
	@Test public void test_2547() {
		checkIsSubtype("!!null","!!void");
	}
	@Test public void test_2548() {
		checkNotSubtype("!!null","!!any");
	}
	@Test public void test_2549() {
		checkIsSubtype("!!null","!!null");
	}
	@Test public void test_2550() {
		checkNotSubtype("!!null","!!int");
	}
	@Test public void test_2551() {
		checkNotSubtype("!!int","any");
	}
	@Test public void test_2552() {
		checkNotSubtype("!!int","null");
	}
	@Test public void test_2553() {
		checkIsSubtype("!!int","int");
	}
	@Test public void test_2554() {
		checkNotSubtype("!!int","[void]");
	}
	@Test public void test_2555() {
		checkNotSubtype("!!int","[any]");
	}
	@Test public void test_2556() {
		checkNotSubtype("!!int","[null]");
	}
	@Test public void test_2557() {
		checkNotSubtype("!!int","[int]");
	}
	@Test public void test_2558() {
		checkNotSubtype("!!int","!void");
	}
	@Test public void test_2559() {
		checkIsSubtype("!!int","!any");
	}
	@Test public void test_2560() {
		checkNotSubtype("!!int","!null");
	}
	@Test public void test_2561() {
		checkNotSubtype("!!int","!int");
	}
	@Test public void test_2562() {
		checkNotSubtype("!!int","[[void]]");
	}
	@Test public void test_2563() {
		checkNotSubtype("!!int","[[any]]");
	}
	@Test public void test_2564() {
		checkNotSubtype("!!int","[[null]]");
	}
	@Test public void test_2565() {
		checkNotSubtype("!!int","[[int]]");
	}
	@Test public void test_2566() {
		checkNotSubtype("!!int","[!void]");
	}
	@Test public void test_2567() {
		checkNotSubtype("!!int","[!any]");
	}
	@Test public void test_2568() {
		checkNotSubtype("!!int","[!null]");
	}
	@Test public void test_2569() {
		checkNotSubtype("!!int","[!int]");
	}
	@Test public void test_2570() {
		checkIsSubtype("!!int","void|void");
	}
	@Test public void test_2571() {
		checkNotSubtype("!!int","void|any");
	}
	@Test public void test_2572() {
		checkNotSubtype("!!int","void|null");
	}
	@Test public void test_2573() {
		checkIsSubtype("!!int","void|int");
	}
	@Test public void test_2574() {
		checkNotSubtype("!!int","any|void");
	}
	@Test public void test_2575() {
		checkNotSubtype("!!int","any|any");
	}
	@Test public void test_2576() {
		checkNotSubtype("!!int","any|null");
	}
	@Test public void test_2577() {
		checkNotSubtype("!!int","any|int");
	}
	@Test public void test_2578() {
		checkNotSubtype("!!int","null|void");
	}
	@Test public void test_2579() {
		checkNotSubtype("!!int","null|any");
	}
	@Test public void test_2580() {
		checkNotSubtype("!!int","null|null");
	}
	@Test public void test_2581() {
		checkNotSubtype("!!int","null|int");
	}
	@Test public void test_2582() {
		checkIsSubtype("!!int","int|void");
	}
	@Test public void test_2583() {
		checkNotSubtype("!!int","int|any");
	}
	@Test public void test_2584() {
		checkNotSubtype("!!int","int|null");
	}
	@Test public void test_2585() {
		checkIsSubtype("!!int","int|int");
	}
	@Test public void test_2586() {
		checkNotSubtype("!!int","[void]|void");
	}
	@Test public void test_2587() {
		checkNotSubtype("!!int","[any]|any");
	}
	@Test public void test_2588() {
		checkNotSubtype("!!int","[null]|null");
	}
	@Test public void test_2589() {
		checkNotSubtype("!!int","[int]|int");
	}
	@Test public void test_2590() {
		checkNotSubtype("!!int","!void|void");
	}
	@Test public void test_2591() {
		checkNotSubtype("!!int","!any|any");
	}
	@Test public void test_2592() {
		checkNotSubtype("!!int","!null|null");
	}
	@Test public void test_2593() {
		checkNotSubtype("!!int","!int|int");
	}
	@Test public void test_2594() {
		checkNotSubtype("!!int","![void]");
	}
	@Test public void test_2595() {
		checkNotSubtype("!!int","![any]");
	}
	@Test public void test_2596() {
		checkNotSubtype("!!int","![null]");
	}
	@Test public void test_2597() {
		checkNotSubtype("!!int","![int]");
	}
	@Test public void test_2598() {
		checkIsSubtype("!!int","!!void");
	}
	@Test public void test_2599() {
		checkNotSubtype("!!int","!!any");
	}
	@Test public void test_2600() {
		checkNotSubtype("!!int","!!null");
	}
	@Test public void test_2601() {
		checkIsSubtype("!!int","!!int");
	}

	private void checkIsSubtype(String from, String to) {
		Type ft = Type.fromString(from);
		Type tt = Type.fromString(to);
		assertTrue(Type.isSubtype(ft,tt));
	}
	private void checkNotSubtype(String from, String to) {
		Type ft = Type.fromString(from);
		Type tt = Type.fromString(to);
		assertFalse(Type.isSubtype(ft,tt));
	}
}
