/**
 * 
 */
/**
 * @author tly
 *
 */
package com.company.board.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class Types {
	//상수
	public static final int		TIME_MILLISECOND			= 1000;				// 초(1000)
	public static final int 	TIME_MIN 					= 60;               // 분(초)
	public static final int 	TIME_HOUR					= 60 * TIME_MIN;	// 시(초)
	public static final int 	TIME_DAY 					= 24 * TIME_HOUR;	// 일(초)
	public static final int 	TIME_WEEK 					= 7 * TIME_DAY;     // 1주(초)
	public static final int 	TIME_MONTH 					= 31 * TIME_DAY;    // 2달(초)
	public static final String	STRING_DELIMITER_1 			= ",";              // 문자 조합 구분자 1
	public static final String	STRING_DELIMITER_2 			= "/";              // 문자 조합 구분자 2
	public static final String	STRING_DELIMITER_3 			= "#";              // 문자 조합 구분자 3
	public static final String	STRING_DELIMITER_4 			= "[|]";            // 문자 조합 구분자 4
	public static final String	STRING_DELIMITER_5 			= "|";              // 문자 조합 구분자 5
	public static final String	STRING_JSON_OBJ 			= "{}";             // JSON Object 기본값
	public static final int		DAILY_RESET_HOUR			= 5;				// 일일 초기화 시각 새벽 5시
	public static final int		WEEK_RESET_DAY				= Calendar.MONDAY;	// 주간 초기화 요일
	public static final int		TIME_CHECK_HEALTH			= 10 * TIME_MIN;	// 헬스 체크 주기
	public static final int		TIME_CHECK_HEALTH_GAP		= 30;				// 헬스 체크 허용 간격

	public static final int		MAX_GOLD					= 9999999;			// 최대 골드 9,999,999
	public static final int		MAX_DP						= 9999999;			// 최대 DP 9,999,999

	public static final int		AUC_CALC_MIN				= 5;				// 동접 합산 주기
	public static final int		SIZE_POSTLIST_PER_PAGE		= 20;				//

	public static final String	REGEXP_PHONE_NO				= "^13\\d{9}$|^14\\d{9}$|^15\\d{9}$|^17\\d{9}$|^18\\d{9}$";
	public static final int		CYCLE_CHECK_PROCESS			= 3;					// 클라이언트 프로세스 체크 주기
	public static final int		MAX_TIMELINE				= 500;					// 최대 타임라인 수

	public static final int		MAX_HERO_CNT				= Integer.MAX_VALUE;	// 최대 캐릭터 생성 개수


	//========================= 추가
	public static final int BASE_WEEKS = 7;

	public static final int TIME_DELAY = 5000;
	public static final long TIME_USER_ACTIVE_CNT = TIME_MIN * TIME_MILLISECOND * 5;


	public static final int SLEEP = 20;
	public static final int IDCOUNT = 50;


	// SDK 관련
//	public static final String	SAUTH_PROP_GAMEID		= "h26";
	public static final String	LOGIN_CHANNEL_NETEASE	= "2mbgame";
	public static final String	LOGO_2MBGAME = "_2mbgame";

	// enum
	// DataSource 종류
	public static enum DataSourceType {
		COMMON, GAME, LEADER, ADMIN
	}

	public static enum IPVer {
		UNKNOWN, IPv4, IPv6
	}

	public static enum ServerState {
		NONE("None"),
		START("Start"),
		START_FAIL("Start Fail"),
		OPEN("Open"),
		CLOSE("Close");

		private String value;

		private ServerState(String value) {
			this.value = value;
		}

		public String getValue() {
			return this.value;
		}

		public static ServerState fromValue(String value) {
			for (ServerState type : values()) {
				if (type.getValue().equalsIgnoreCase(value))
					return type;
			}
			return null;
		}
	}

	// Common 설정
	public static enum CommonType {
		NEEDTICKETCOUNT(1)		// 디펜스모드의 입장 티켓 수량
		, DAILYMISSION_REWARD(2)	// 일일 미션 최종 보상값 DWT
		, DURABILITYCOST(3)		// 내구도 차감 수치
		, ENERGYMAX(4)			// 최대 에너지
		, ENERGYCOOLTIME(5)		// 에너지 쿨타임 시간(초 값)
		, LEADERBOARDSTART(6)		// 주간제 시작날짜
		, WEEKLYTIMEVALUE(7)		// 주간제 기간 (시간값)
		, CALCULATETIME(8)		// 주간제 정산시간( 시간값)
		, SCENARIOLIMIT(9)		// 시나리오 일일 제한 횟수
		, RANKINSERTTIME(10)		// 최초 설정 시간: 25분
		, DURABILITYCREDIT(11)	// 내구도 1당 필요 골드값
		, DEFAULTWEAPON(12)		// 기본총기
		, FEVERTIME(13)			// 피버타임 시간 (단위: 초)
		, FEVERPOINT_NORMAL(14)	// 피버타임 노멀좀비 포인트
		, FEVERPOINT_ELITE(15)	// 피버타임 정예좀비 포인트
		, FEVERPOINT_BOSS(16)		// 피버타임 보스좀비 포인트
		, FEVERPOINT_HEADSHOT(17)	// 피버타임 헤드샷 포인트
		;

		private int value;
		private CommonType(int value) { this.value = value; }

		public int getValue() { return this.value; }
		public static CommonType fromValue(int value) {
			for(CommonType type : values()) {
				if(type.value == value)
					return type;
			}
			return null;
		}
	}

	// Smart Factory Data Type
	public static enum CmsDataType {
		ALL("all")
		, CMS_SERVER("GameServer")
		, WHITE_LIST("WhiteList")
		, ABILITY("TableData_Ability")
		, SCENARIOMODEINFO("TableData_SenarioModeInfo")
		, COMMON("TableData_Common")
		, GUNSTAT("TableData_GunStat")
		, HERONEW("TableData_HeroNew")
		, ITEM("TableData_Item")
		, ITEMBOX("TableData_ItemBox")
		, LOCALIZINGSTRING("TableData_LocalizingString")
		, MODEINFO("TableData_ModeInfo")
		, NPC("TableData_Npc")
		, OBJECT("TableData_Object")
		, SOUND("TableData_Sound")
		, SURVIVALMODEINFO("TableData_SurvivalModeInfo")
//		, WALLET("TableData_Wallet")
		, ZOMBIESTAT("TableData_ZombieStat")
		, ZOMBIESKILL("TableData_ZombieSkill")
		, FILTERING("TableData_FilteringText")
		, GOLDREWARD("TableData_GoldReward")
		, RANKREWARD("TableData_RankReward")
		, DECAL("TableData_Decal")
		, SPECIALITEM("TableData_SpecialItem")
		, SPECIALSTAT("TableData_SpecialStat")
		, SUBWEAPON("TableData_SubWeapon")
		, SUBWEAPONSTAT("TableData_SubWeaponStat")
		, THROWWEAPON("TableData_ThrowWeapon")
		, THROWWEAPONSTAT("TableData_ThrowWeaponStat")
		, MAINWEAPON("TableData_MainWeapon")
		, MEDAL1("TableData_Medal1")
		, MEDAL2("TableData_Medal2")
		, MEDAL3("TableData_Medal3")
		, STORE("TableData_Store")
		, MISSION("TableData_Mission")
		, MYROOMLV("TableData_MyRoomLv")
		, SKINAK47("TableData_SkinAK47")
		, SKINBR50("TableData_SkinBR50")
		, SKINI37("TableData_SkinI37")
		, SKINLM86("TableData_SkinLM86")
		, SKINM4A1("TableData_SkinM4A1")
		, SKINMAS12("TableData_SkinMAS12")
		, SKINMPK("TableData_SkinMPK")
		, SKINPAS12("TableData_SkinPAS12")
		, SKINQ87("TableData_SkinQ87")
		, SKINR7("TableData_SkinR7")
		, SKINSARH("TableData_SkinSARH")
		, SKINTSR9("TableData_SkinTSR9")
		, SKINUZX("TableData_SkinUZX")
		, DEFENSEMODEINFO("TableData_DefenseModeInfo")
		, STAKING("TableData_Staking")
		;

		private String value;

		private CmsDataType(String value) {
			this.value = value;
		}

		public String getValue() {
			return this.value;
		}

		public String getFileName() {
			return this.value + ".csv";
		}

		public static CmsDataType fromValue(String value) {
			for (CmsDataType type : values()) {
				if (type.getValue().equalsIgnoreCase(value))
					return type;
			}
			return null;
		}

		public static List<String> getTableNames() {
			List<String> list = new ArrayList<String>();
			for (CmsDataType type : values()) {
				if (type != ALL) {
					list.add(type.getValue());
				}
			}
			return list;
		}
	}

	// 게임 데이터 타입
	public static enum CmsDataNumber {
		ALL(0, "all")
		, ABILITY(1, "TableData_Ability")
		, SCENARIOMODEINFO(2, "TableData_SenarioModeInfo")
		, COMMON(3, "TableData_Common")
		, GUNSTAT(4, "TableData_GunStat")
		, HERO(5, "TableData_Hero")
		, ITEM(6, "TableData_Item")
		, ITEMBOX(7, "TableData_ItemBox")
		, LOCALIZINGSTRING(8, "TableData_LocalizingString")
		, MODEINFO(9, "TableData_ModeInfo")
		, NPC(10, "TableData_Npc")
		, OBJECT(11, "TableData_Object")
		, SOUND(12, "TableData_Sound")
		, SURVIVALMODEINFO(13, "TableData_SurvivalModeInfo")
//		, WALLET(17, "TableData_Wallet")
		, ZOMBIESTAT(14, "TableData_ZombieStat")
		, ZOMBIESKILL(15, "TableData_ZombieSkill")
		, FILTERING(16, "TableData_FilteringText")
		, GOLDREWARD(17, "TableData_GoldReward")
		, RANKREWARD(18, "TableData_RankReward")
		, DECAL(19, "TableData_Decal")
		, SPECIALITEM(20, "TableData_SpecialItem")
		, SPECIALSTAT(21, "TableData_SpecialStat")
		, SUBWEAPON(22, "TableData_SubWeapon")
		, SUBWEAPONSTAT(23, "TableData_SubWeaponStat")
		, THROWWEAPON(24, "TableData_ThrowWeapon")
		, THROWWEAPONSTAT(25, "TableData_ThrowWeaponStat")
		, MAINWEAPON(26, "TableData_MainWeapon")
		, MEDAL1(27, "TableData_Medal1")
		, MEDAL2(28, "TableData_Medal2")
		, MEDAL3(29, "TableData_Medal3")
		, STORE(30, "TableData_Store")
		, MISSION(31, "TableData_Mission")
		, MYROOMLV(32, "TableData_MyRoomLv")
		, SKINAK47(33, "TableData_SkinAK47")
		, SKINBR50(34, "TableData_SkinBR50")
		, SKINI37(35, "TableData_SkinI37")
		, SKINLM86(36, "TableData_SkinLM86")
		, SKINM4A1(37, "TableData_SkinM4A1")
		, SKINMAS12(38, "TableData_SkinMAS12")
		, SKINMPK(39, "TableData_SkinMPK")
		, SKINPAS12(40, "TableData_SkinPAS12")
		, SKINQ87(41, "TableData_SkinQ87")
		, SKINR7(42, "TableData_SkinR7")
		, SKINSARH(43, "TableData_SkinSARH")
		, SKINTSR9(44, "TableData_SkinTSR9")
		, SKINUZX(45, "TableData_SkinUZX")
		, DEFENSEMODEINFO(46, "TableData_DefenseModeInfo")
		;

		private byte value;
		private String name;
		private CmsDataNumber(int value, String name) {
			this.value = (byte)value;
			this.name = name;
		}

		public byte getValue() {return this.value;}
		public String getName() {return this.name;}
		public String getFileName() {return this.name + ".csv";}
		public static CmsDataNumber fromValue(int value) {
			for (CmsDataNumber type : values()) {
				if (type.getValue() == (byte)value)
					return type;
			}
			return null;
		}

		public static CmsDataNumber fromValue(String name) {
			for(CmsDataNumber type : values()) {
				if(type.getName().equals(name))
					return type;
			}
			return null;
		}

		public static List<String> getTableNames() {
			List<String> list = new ArrayList<String>();
			for (CmsDataNumber type : values()) {
				if (type != ALL) {
					list.add(type.name);
				}
			}
			return list;
		}
	}



//	// 게임 데이터 타입
//	public static enum GameDataType {
//		ALL("all")
//		, GAME_SERVER("GameServer")
//		, GM_TOOL("GMTool")
////		, STRINGS("String")
////		, USER_LEVEL("USER_LV")
////		, REWARD("REWARD")
////		, COSTUME("COSTUME")
////		, POSTTEXT("TOOL")
//		;
//
//		private String value;
//
//		private GameDataType(String value) {
//			this.value = value;
//		}
//
//		public String getValue() {
//			return this.value;
//		}
//
//		public String getFileName() {
//			return this.value + ".csv";
//		}
//
//		public static GameDataType fromValue(String value) {
//			for (GameDataType type : values()) {
//				if (type.getValue().equalsIgnoreCase(value))
//					return type;
//			}
//			return null;
//		}
//
//		public static List<String> getTableNames() {
//			List<String> list = new ArrayList<String>();
//			for (GameDataType type : values()) {
//				if (type != ALL) {
//					list.add(type.getValue());
//				}
//			}
//			return list;
//		}
//	}

	public static enum Boolean {
		FALSE(0),
		TRUE(1);
		private byte value;

		private Boolean(int value) {
			this.value = (byte) value;
		}

		public byte getValue() {
			return this.value;
		}

		public static boolean checkValue(byte value) {
			return (TRUE.value == value);
		}

		public static boolean checkValid(int value) {
			return (FALSE.value == value || TRUE.value == value);
		}

		public static Boolean fromBoolean(boolean value) {
			if (value) return TRUE;
			else return FALSE;
		}

		public static int getValueBoolean(boolean value) {
			if (value) return TRUE.getValue();
			else return FALSE.getValue();
		}
	}

	// 유저 상태 (가입, 이미 가입, 탈퇴)
	public static enum CreateUserType {
		NONE(0),
		CREATE(1),
		EXIST(2),
		WITHDRAW(3)
		;
		private byte value;
		private CreateUserType(int value) { this.value = (byte)value; }
		public byte getValue() { return this.value; }
		public static CreateUserType fromValue(int value) {
			for(CreateUserType type : values()) {
				if(type.value == (byte)value) {
					return type;
				}
			}
			return null;
		}
	}

	// 계정 가입채널
	public static enum AppChannel {
		COMMON(0, ""),
		DEV  (1, "dev"),
		GOOGLE (2, "GOOGLE"),
		APPLE (3, "APPLE"),
		FACEBOOK (4, "FACEBOOK"),
		GUEST (99, "GUEST"),
		;
		private byte value;
		private String appchannel;
		private AppChannel(int value, String appchannel) {
			this.value		= (byte)value;
			this.appchannel		= appchannel;
		}
		public static AppChannel fromValue(byte value) {
			for (AppChannel type : values()) {
				if (type.value == value)
					return type;
			}
			return COMMON;
		}
		public static AppChannel fromAppChannel(String appchannel) {
			for (AppChannel type : values()) {
				if (type.appchannel.equals(appchannel))
					return type;
			}
			return COMMON;
		}
		public byte getValue() {
			return this.value;
		}
		public String getAppChannel() {
			return this.appchannel;
		}
	}

	// 마켓
	public static enum Platform {
		COMMON(0, ""),
		DEV  (1, "dev"),
		GOOGLE (2, "GOOGLE"),
		APPLE (3, "APPLE"),
		;
		private byte value;
		private String platform;
		private Platform(int value, String platform) {
			this.value		= (byte)value;
			this.platform		= platform;
		}
		public static Platform fromValue(byte value) {
			for (Platform type : values()) {
				if (type.value == value)
					return type;
			}
			return COMMON;
		}
		public static Platform fromPlatform(String platform) {
			for (Platform type : values()) {
				if (type.platform.equals(platform))
					return type;
			}
			return COMMON;
		}
		public byte getValue() {
			return this.value;
		}
		public String getPlatform() {
			return this.platform;
		}
	}

	// 서바이벌 챕터
	public static enum SurvivalType {
		SURVIVAL_01(1)
//		, SURVIVAL_02(2)
//		, SURVIVAL_03(3)
//		, SURVIVAL_04(4)
//		, SURVIVAL_05(5)
//		, SURVIVAL_06(6)
//		, SURVIVAL_07(7)
//		, SURVIVAL_08(8)
//		, SURVIVAL_09(9)
//		, SURVIVAL_10(10)
		;
		private int value;
		private SurvivalType(int value) {this.value = value;}

		public int getValue() {return this.value;}
		public static SurvivalType fromValue(int value) {
			for(SurvivalType type : values()) {
				if(type.value == value)
					return type;
			}
			return null;
		}
		public static String getDefaultSurvivalState() {
			StringBuilder sb = new StringBuilder();

			int count = 0;
			for(SurvivalType type : values()) {
				if(count > 0)
					sb.append(Types.STRING_DELIMITER_1);

				sb.append(type.value);
				sb.append(Types.STRING_DELIMITER_3);

				// 1번 스테이지만 1, 나머지는 0 -> 1#1,2#0,3#0 -> 스테이지번호#난이도번호(1~6) <난이도 하위의 레벨은 기제하지 않음>
				// 1개의 맵에 6개의 난이도가 있고, 각 난이도 하위에 5개의 레벨이 존재함
				if (count == 0) sb.append(1);
				else sb.append(0);

				++count;
			}
			return sb.toString();
		}
	}

	// 시나리오 챕터
	public static enum ScenarioType {
		SCENARIO_01(1)
//		, SCENARIO_02(2)
//		, SCENARIO_03(3)
//		, SCENARIO_04(4)
//		, SCENARIO_05(5)
//		, SCENARIO_06(6)
//		, SCENARIO_07(7)
//		, SCENARIO_08(8)
//		, SCENARIO_09(9)
//		, SCENARIO_10(10)
		;
		private int value;
		private ScenarioType(int value) {this.value = value;}

		public int getValue() {return this.value;}
		public static ScenarioType fromValue(int value) {
			for(ScenarioType type : values()) {
				if(type.value == value)
					return type;
			}
			return null;
		}
		public static String getDefaultScenarioState() {
			StringBuilder sb = new StringBuilder();

			int count = 0;
			for(ScenarioType type : values()) {
				if(count > 0)
					sb.append(Types.STRING_DELIMITER_1);

				sb.append(type.value);
				sb.append(Types.STRING_DELIMITER_3);

				// 1번 스테이지만 1, 나머지는 0 -> 1#1,2#0,3#0 -> 스테이지번호#난이도번호(1~6) <난이도 하위의 레벨은 기제하지 않음>
				// 1개의 맵에 6개의 난이도가 있고, 각 난이도 하위에 5개의 레벨이 존재함
				if (count == 0) sb.append(1);
				else sb.append(0);

				++count;
			}
			return sb.toString();
		}
	}

	// 재화 타입
	public static enum GemType {
		NONE(0)		// None
		, GOLD(1)		// 게임머니
		, DP(2)		// DDW-P : 빌링 시스템을 통해 현금으로 구입하는 캐쉬 재화 : 싸이월드 도토리 개념
		;

		private byte value;
		private GemType(int value) {this.value = (byte)value;}

		public byte getValue() {return this.value;}
		public static GemType fromValue(byte value) {
			for (GemType type : values()) {
				if (type.value == value)
					return type;
			}
			return NONE;
		}
	}

	// 무기 타입
	public static enum WeaponType {
		GUN(1, "총기"),			// 총기
		MELEE(2, "근접무기"),		// 근접무기
		THROW(3, "투척무기"),		// 투척무기
		SPECIAL(4, "특수아이템")	// 특수아이템
		;
		private int value;
		private String name;
		private WeaponType(int value, String name) {
			this.value = value;
			this.name = name;
		}

		public int getValue() {
			return this.value;
		}
		public String getName() {
			return this.name;
		}
		public static WeaponType fromValue(int value) {
			for(WeaponType type : values()) {
				if(type.value == (byte)value)
					return type;
			}
			return null;
		}
	}

	// 총기 타입
	public static enum GunType {
		NONE(0, "")							// 세부타입없음
		, ASSAULTRIFLE(1, "어썰트라이플")		// 어썰트라이플
		, SUBMACHINEGUN(2, "서브머신건")		// 서브머신건
		, SNIPERIFLE(3, "스나이퍼라이플")		// 스나이퍼라이플
		, SHOTGUN(4, "샷건")					// 샷건
		, MACHINEGUN(5, "머신건")				// 머신건
		, LAUNCHER(6, "런처")				// 런처
		, PISTOL(7, "피스톨")					// 피스톨
		;
		private int value;
		private String name;
		private GunType(int value, String name) {
			this.value = value;
			this.name = name;
		}

		public int getValue() {
			return this.value;
		}
		public String getName() { return this.name; }
		public static GunType fromValue(int value) {
			for(GunType type : values()) {
				if(type.value == (byte)value)
					return type;
			}
			return null;
		}
		public static String fromName(int value) {
			for(GunType type : values()) {
				if(type.value == (byte)value)
					return type.name;
			}
			return null;
		}
	}

	// 총기 모델
	public static enum GunModel {
		AK_47(1)
		, M4A1(2)
		, SAR_H(3)
		, MAS_12(4)
		, PAS_12(5)
		, I37(6)
		, UZ_X(7)
		, MP_K(8)
		, TSR_9(9)
		, BR_50(10)
		, R7(11)
		, Q_87(12)
		, LM86(13)
		;
		private int value;
		private GunModel(int value) { this.value = value; }

		public int getValue() {
			return this.value;
		}
		public static GunModel fromValue(int value) {
			for(GunModel type : values()) {
				if(type.value == (byte)value)
					return type;
			}
			return null;
		}
	}

	// 총기 등급
	public static enum GunGrade {
		BASIC(1)
		, PRIME(2)
		, ELITE(3)
		, EXPERT(4)
		, MASTER(5)
		;
		private int value;
		private GunGrade(int value) { this.value = value; }

		public int getValue() {
			return this.value;
		}
		public static GunGrade fromValue(int value) {
			for(GunGrade type : values()) {
				if(type.value == (byte)value)
					return type;
			}
			return null;
		}
	}

	// 근접무기 타입
	public static enum MeleeType {
		NONE(0, "")						// 세부타입없음
		, SHORTRANGE(1, "단거리")			// 단거리
		, INTERMEDIATERANGE(2, "중거리")	// 중거리
		, LONGRANGE(3, "장거리"),			// 장거리
		;
		private int value;
		private String name;
		private MeleeType(int value, String name) {
			this.value = value;
			this.name = name;
		}

		public int getValue() {
			return this.value;
		}
		public String getName() {
			return this.name;
		}
		public static MeleeType fromValue(int value) {
			for(MeleeType type : values()) {
				if(type.value == (byte)value)
					return type;
			}
			return null;
		}
		public static String fromName(int value) {
			for(MeleeType type : values()) {
				if(type.value == (byte)value)
					return type.name;
			}
			return null;
		}
	}

	// 투척무기 타입
	public static enum ThrowType {
		NONE(0, "")			// 세부타입없음
		, DIRECT(1, "직사")	// 직사
		, CURVED(2, "곡사")	// 곡사
		;
		private int value;
		private String name;
		private ThrowType(int value, String name) {
			this.value = value;
			this.name = name;
		}

		public int getValue() {
			return this.value;
		}
		public String getName() {
			return this.name;
		}
		public static ThrowType fromValue(int value) {
			for(ThrowType type : values()) {
				if(type.value == (byte)value)
					return type;
			}
			return null;
		}
		public static String fromName(int value) {
			for(ThrowType type : values()) {
				if(type.value == (byte)value)
					return type.name;
			}
			return null;
		}
	}

	// 특수아이템 타입
	public static enum SpecialType {
		NONE(0, "")				// 세부타입없음
		, HEALPACK(1, "회복")	// 회복
		, AMMO(2, "탄약")		// 탄약
		;
		private int value;
		private String name;
		private SpecialType(int value, String name) {
			this.value = value;
			this.name = name;
		}

		public int getValue() {
			return this.value;
		}
		public String getName() {
			return this.name;
		}
		public static SpecialType fromValue(int value) {
			for(SpecialType type : values()) {
				if(type.value == (byte)value)
					return type;
			}
			return null;
		}
		public static String fromName(int value) {
			for(SpecialType type : values()) {
				if(type.value == (byte)value)
					return type.name;
			}
			return null;
		}
	}

	public static enum DateFormatType {
		NONE(-1),
		YYYYMMDD(0),
		YYYYMMDDHHMMSS(1),
		YYYYMMDDHHMM(2),
		YYYYMMDDHH(3),
		;

		private int value;

		private DateFormatType(int value) {
			this.value = value;
		}

		public int getValue() {
			return this.value;
		}
	}

	public static enum DateType {
		NONE(0)
		, YEAR(1)
		, MONTH(2)
		, DAY(3)
		, HOUR(4)
		, MINITE(5)
		, SECOND(6)
		;

		private byte value;
		private DateType(int value) { this.value = (byte)value; }
		public byte getValue() { return this.value; }
		public static DateType fromValue(int value) {
			for(DateType type : values()) {
				if(type.value == (byte) value) {
					return type;
				}
			}
			return null;
		}
	}


	public static enum ResultType {
		FAIL_DATAERROR(-1),
		FAIL_NODATA(0),
		SUCCESS_OK(1),
		FAIL_EXCEPTION(2),
		FAIL_LIMIT(3);

		private int value;

		private ResultType(int value) {
			this.value = value;
		}

		public int getValue() {
			return this.value;
		}

		public static ResultType fromValue(int value) {
			for (ResultType type : values()) {
				if (type.getValue() == value) {
					return type;
				}
			}
			return null;
		}
	}

	public static enum ResultMsg {
		OK("ok"),
		FAIL("fail"),
		DATAERROR("Data error"),
		NODATA("No data"),
		SUCCESS("success");

		private String value;

		private ResultMsg(String value) {
			this.value = value;
		}

		public String getValue() {
			return this.value;
		}
	}

	public static enum NumberFormat {
		NONE(0), INTEGER(1), STRING(2), INTANDSTR(3);
		private int value;

		private NumberFormat(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}

		public static NumberFormat fromValue(int value) {
			for (NumberFormat type : values()) {
				if (type.getValue() == value) {
					return type;
				}
			}
			return null;
		}
	}

	public static enum StatusType {
		NONE(0), PARAMETER(10), DATA_ERR(12), ISDIRECTORY(100), NODATA(200);
		private int value;

		private StatusType(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}

		public static StatusType fromValue(int value) {
			for (StatusType type : values()) {
				if (type.getValue() == value) {
					return type;
				}
			}
			return null;
		}
	}

	public static enum ValueDateType {
		NONE(0), DateType(1), DateTypeReplace(2), ValueType(3);

		private int value;

		private ValueDateType(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}

		public static ValueDateType fromValue(int value) {
			for (ValueDateType type : values()) {
				if (type.getValue() == value) {
					return type;
				}
			}
			return null;
		}
	}


	public static enum ProState {
		NONE(0)
		,UPDATEONLY(1)	//	싱글업데이트
		,UPDATEMULTI(2)	//	전체
		,INPUTPAGE(3)		// 	페이지 번호 직접입력
		;
		private byte value;
		private ProState(int value) {
			this.value = (byte)value;
		}
		public byte getValue() {
			return this.value;
		}
		public static ProState fromValue(byte value) {
			for(ProState type : values()) {
				if(type.value == value) {
					return type;
				}
			}
			return null;
		}
	}

	public static enum StateType {
		NONE(0)
		, ACTIVE(1)
		, INACTIVE(2)
		;

		private byte value;
		private StateType(int value) {
			this.value = (byte) value;
		}
		public byte getValue() {
			return this.value;
		}
		public static StateType fromValue(int value) {
			for(StateType type : values()) {
				if(type.value == (byte)value) {
					return type;
				}
			}
			return null;
		}
	}

	public static enum ContentsType {
		CAMERA(10)
		, EDITER(20)
		;

		private byte value;
		private ContentsType(int value) {
			this.value = (byte)value;
		}
		public byte getValue() {
			return this.value;
		}
		public static ContentsType fromValue(int value) {
			for(ContentsType type : values()) {
				if(type.value == (byte)value) {
					return type;
				}
			}
			return null;
		}
	}

	// 결재 타입
	public static enum PayTypes {
		NONE(0, "none")
		, CARD(1, "card")
		, MONEY(2, "money")
		;
		private byte value;
		private String name;
		private PayTypes(int value, String name) {
			this.value = (byte)value;
			this.name = name;
		}
		public byte getValue() {
			return this.value;
		}
		public String getName() {
			return this.name;
		}
		public static PayTypes fromValue(String name) {
			for(PayTypes type : values()) {
				if(type.name.equals(name) == true) {
					return type;
				}
			}
			return NONE;
		}
	}

	// DayCountTypes
	public static enum DayCountTypes {
		NONE(0)
		, BEFORE(2)
		, SEVENDAY(7)
		, THIRTY(30)
		, NINETY(90)
		;

		private byte value;
		private DayCountTypes(int value) {
			this.value = (byte)value;
		}

		public byte getValue() {
			return this.value;
		}
	}

	// 로그 타입
	public static enum GameLogType {
		DEFAULT(99
				, "default"
				, "전체"
				, Arrays.asList(2200,5500,3700,3700)
				, Arrays.asList("유저번호","등록일시","Ip", "보유 DDW-C")
				, Arrays.asList("userNo","mgdc_logtime","ip","userGold")
				, Arrays.asList(99))
		, SIGNUP(0
				, "Signup"
				, "회원가입"
				, Arrays.asList(10500, 2500)
				, Arrays.asList("게임팟ID", "플랫폼")
				, Arrays.asList("aid", "app_ch")
				, Arrays.asList(0))
		, LOGIN(1
				, "Login"
				, "로그인"
				, Arrays.asList()
				, Arrays.asList()
				, Arrays.asList()
				, Arrays.asList(1))
		, LOGOUT(2
				, "Logout"
				, "로그아웃"
				, Arrays.asList(2200)
				, Arrays.asList("온라인타임")
				, Arrays.asList("logout_time")
				, Arrays.asList(2))
//		, CREATE(3, "Create", "히어로생성")
//		, CREATENICKNAME(4, "CreateNickName", "닉네임생성")
		, STARTGAME(5
				, "StartGame"
				, "게임시작"
				, Arrays.asList(10000,3000,2000,5000)
				, Arrays.asList("게임키","스테이지","맵번호","tokenId")
				, Arrays.asList("game_key","modType","index","tokenId")
				, Arrays.asList(5))
//		, GETREWARD(6
//				, "GetReward"
//				, "렌덤보상획득"
//				, Arrays.asList(10000,3000,3000,3000,3000)
//				, Arrays.asList("게임키","보급상자번호","아이템타입","아이템번호","획득골드")
//				, Arrays.asList("game_key","rewardNo","item_type","item_index","gold")
//				, Arrays.asList(6))
		, FINISHGAME(7
				, "FinishGame"
				, "게임종료"
				, Arrays.asList(10000,3000,2000,5000,2200,2200,3500)
				, Arrays.asList("게임키","스테이지","맵번호","tokenId","성공여부","획득골드","플레이시간(초)")
				, Arrays.asList("game_key","modType","index","tokenId","isClear","gold","play_time")
				, Arrays.asList(7))
		, BUYITEM(8
				, "BuyItem"
				, "아이템구매"
				, Arrays.asList(3000,3000,2500)
				, Arrays.asList("아이템번호","아이템수량","사용골드")
				, Arrays.asList("index","count","gold")
				, Arrays.asList(8))
//		, INITENVIRON(9, "InitEnviron", "초기환경설정")
		, FINISHLOG(10
				, "Finish"
				, "게임종료로그"
				, Arrays.asList(10000,3000,2200,2200,2200,2200,3000,3000,3000,3000,3000
								,3000,2000,3000,5000,2200,7000,2200)
				, Arrays.asList("게임키","tokenId","헤드샷","총기킬수","사용총알","적중총알","근접무기","근접무기킬","투척무기","투척무기킬","특수무기"
								,"스테이지","맵번호","성공여부","오브젝트","획득보급상자","그래픽카드","플레이시간(초)")
				, Arrays.asList("game_key","tokenId","head_shot_count","gun_kill_count","gun_acc_ammo","gun_fire_count","weapon_id2","melee_kill_count","weapon_id3","throw_kill_count","weapon_id4"
				,"modType","index","success_bool","clear_object_id","get_supply_value","graphic_card","play_time")
				, Arrays.asList(10))
		, CONTINUEGAME(11
				, "continueGame"
				,"게임부활"
				, Arrays.asList(10000,3000,3000,3000)
				, Arrays.asList("게임키","스테이지","맵번호","사용골드")
				, Arrays.asList("game_key","modType","index","gold")
				, Arrays.asList(11))
		, REPAIR(12
				, "repair"
				,"총기수리"
				, Arrays.asList(5000,5000,5000,5000,3000)
				, Arrays.asList("총기목록","수리 전","수리 후","사용 골드","총 사용 골드")
				, Arrays.asList("tokenIdList","beforeList","afterList","goldList","gold")
				, Arrays.asList(12))
		, LEADER(13
				, "leader"
				,"랭킹등록"
				, Arrays.asList(10000,3000,3000,3000,5000,15000,3000,3000,3000,3000)
				, Arrays.asList("게임키","스테이지","맵번호","히어로","tokenId","주무기","보조무기","투척무기","스페셜아이템","플레이시간(초)")
				, Arrays.asList("game_key","modType","index","hero","tokenId","main_weapon","sub_weapon","throw_weapon","special_item","play_time")
				, Arrays.asList(13))
		, LEADERRECEIVE(14
				, "leaderReceive"
				,"랭킹보상"
				, Arrays.asList(3000,3000,3000,3000)
				, Arrays.asList("스테이지","맵번호","랭크","획득골드")
				, Arrays.asList("mod_type","map_num","rank","gold")
				, Arrays.asList(14))
		, MISSION(15
				, "dailyMission"
				,"일일미션"
				, Arrays.asList(10000,5000,3000,3000)
				, Arrays.asList("게임키","스테이지","맵번호","획득골드")
				, Arrays.asList("game_key","modType","index","gold")
				, Arrays.asList(15))
		, LEVELUP(16
				, "LevelUp"
				,"레벨업"
				, Arrays.asList(3000,3000,3000,3000)
				, Arrays.asList("레벨업타입","레벨업 전","레벨업 후","사용골드")
				, Arrays.asList("levelup_type","beforeLevel","afterLevel","gold")
				, Arrays.asList(16))
		, DEPOSIT(197
				, "DepositList"
				, "DDW-C 입금내역"
				, Arrays.asList(11000,3000,3000,3000,5500)
				, Arrays.asList("Request Key","분류","금액","결과","처리일자")
				, Arrays.asList("key","type","amount","status","updDate")
				, Arrays.asList(197)) // 입금 (지갑->게임) Deposit
		, CLAIM(198
				, "ClaimList"
				, "DDW-C 출금내역"
				, Arrays.asList(11000,3000,3000,3000,5500)
				, Arrays.asList("Request Key","분류","금액","결과","처리일자")
				, Arrays.asList("key","type","amount","status","updDate")
				, Arrays.asList(198)) // 출금 (게임->지갑) Claim
		, SYCN(199
				, "WalletSyncList"
				, "지갑연동 내역"
				, Arrays.asList(11000,3000,3000,3000,5500)
				, Arrays.asList("Request Key","분류","금액","결과","처리일자")
				, Arrays.asList("key","type","amount","status","updDate")
				, Arrays.asList(199)) // 출금 (게임->지갑) Claim
//		, GOLDHISTORY(96
//				, "GoldHistory"
//				, "재화내역"
//				, Arrays.asList(5000,5000,5000)
//				, Arrays.asList("로그타입","획득골드","사용골드")
//				, Arrays.asList("logName","userGold","gold")
//				, Arrays.asList(7,8,11,12,14,15,16))
		, ACQUIREGOLD(97
				, "AcquireGold"
				, "재화획득"
				, Arrays.asList(5000,5000)
				, Arrays.asList("로그타입","획득골드")
				, Arrays.asList("logName","gold")
				, Arrays.asList(7,14,15)) //종료, 랭킹보상, 일일미션
		, CONSUMEGOLD(98
				, "ConsumeGold"
				, "재화소모"
				, Arrays.asList(5000,5000)
				, Arrays.asList("로그종류","사용골드")
				, Arrays.asList("logName","gold")
				, Arrays.asList(8,11,12,16))//아이템구매, 부활, 수리, 레벨업

		;

		private int value;
		private String logType;
		private String logTypeKor;
		private List<Integer> colWidths;
		private List<String> colNames;
		private List<String> insNames;
		private List<Integer> logTypes; //실제로 몽고DB에서 찾아오는 logId 리스트

		private GameLogType(int value, String logType, String logTypeKor, List<Integer> colWidths, List<String> colNames, List<String> insNames, List<Integer> logTypes) {
			this.value = value;
			this.logType = logType;
			this.logTypeKor = logTypeKor;
			this.colWidths = colWidths;
			this.colNames = colNames;
			this.insNames = insNames;
			this.logTypes = logTypes;
		}

		public static GameLogType fromValue(int value) {
			for (GameLogType type : values()) {
				if (type.value == value)
					return type;
			}
			return DEFAULT;
		}

		public static GameLogType fromLogtype(String logType) {
			for (GameLogType type : values()) {
				if (type.logType.equals(logType))
					return type;
			}
			return DEFAULT;
		}

		public int getValue() {
			return this.value;
		}
		public String getlogType() {
			return this.logType;
		}
		public String getlogTypeKor() {
			return this.logTypeKor;
		}
		public List<Integer> getColWidths() {
			return this.colWidths;
		}
		public List<String> getColNames() {
			return this.colNames;
		}
		public List<String> getInsNames() {
			return this.insNames;
		}
		public List<Integer> getLogTypes() { return this.logTypes; }
	}


	// 게임 모드 타입
	public static enum ModType {
		NONE(0, "----","----")					// 모드타입없음
		, SURVIVALMODEINFO(1,"서바이벌", "Survival")		// 서바이벌
		, SCENARIOMODEINFO(2,"시나리오","Scenario")		// 시나리오
		, DEFENCE(3,"디펜스","Defence")				// 디펜스
		;
		private int value;
		private String modTypeKor;
		private String modTypeEng;
		private ModType(int value, String modTypeKor, String modTypeEng) {
			this.value = value;
			this.modTypeKor = modTypeKor;
			this.modTypeEng = modTypeEng;

		}

		public int getValue() {
			return this.value;
		}
		public String getModTypeKor() {return this.modTypeKor;}
		public String getModTypeEng() {return this.modTypeEng;}
		public static ModType fromValue(int value) {
			for(ModType type : values()) {
				if(type.value == (byte)value)
					return type;
			}
			return null;
		}
	}

	// 아이템 카테고리 타입
	public static enum ItemType {
		WALLET(0, "재화타입")				// 재화타입
		, HERO(1, "영웅타입")				// 영웅타입
		, THROWINGWEAPON(2, "투척무기타입")	// 투척무기타입
		, SPECIALITEM(3, "특수아이템타입")		// 특수아이템타입
		, TICKET(4, "입장권타입")			// 입장권타입
		, FINITEITEM(5, "소모성아이템타입")		// 소모성아이템타입
		, ITEMBOX(6, "아이템상자타입")			// 아이템상자타입
		;

		private int value;
		private String name;
		private ItemType(int value, String name) {
			this.value = value;
			this.name = name;
		}

		public int getValue() {
			return this.value;
		}

		public String getName() {
			return this.name;
		}

		public static ItemType fromValue(int value) {
			for(ItemType type : values()) {
				if(type.value == (byte)value)
					return type;
			}
			return null;
		}
	}


	// 지갑 거래 상태 타입
	public static enum WalletStatusType {
		NONE(-1)				// 상태없음
		, ERROR(0)			// 실패
		, SUCCESS(1)			// 성공
		, PENDING(2)			// 펜딩
		, TIMEOUT_SYSTEM(3)	// 타임아웃(시스템)
		, TIMEOUT_USER(4)		// 타임아웃(유저)
		, WAITING(5)			// 대기(콜백 응답 전 상태)
		;
		private byte value;
		private WalletStatusType(int value) { this.value = (byte)value; }

		public byte getValue() { return this.value; }
		public static WalletStatusType fromValue(int value) {
			for(WalletStatusType type : values()) {
				if(type.value == (byte)value)
					return type;
			}
			return null;
		}
	}


	// 집계 로그 타입
	public static enum statisticType {
		DEFAULT(99
				, "default"
				, "전체"
				, Arrays.asList(5500,5500)
				, Arrays.asList("구분","수")
				, Arrays.asList("id","count"))
		, LOGIN(1
				, "LoginCount"
				, "일일 접속유저"
				, Arrays.asList()
				, Arrays.asList()
				, Arrays.asList())
		, LOGOUT(2
				, "SignUpCount"
				, "일일 가입자 수"
				, Arrays.asList()
				, Arrays.asList()
				, Arrays.asList())
		, CREATE(3
				, "ModeCount"
				, "일일 모드별 플레이어수"
				, Arrays.asList()
				, Arrays.asList()
				, Arrays.asList())
		, CREATENICKNAME(4
				, "BuyItemCount"
				, "상점 판매량"
				, Arrays.asList(5500)
				, Arrays.asList("타입")
				, Arrays.asList("type"))
		, DDWCRANK(5
				, "DDW-C Rank"
				, "DDW-C 보유순위"
				, Arrays.asList(3000, 3000, 4000, 5500)
				, Arrays.asList("번호","유저번호","보유한 DDW-C","회원가입일")
				, Arrays.asList("no", "userNo", "gold", "creDate")) // 입금 (지갑->게임) Deposit
		, DAYDDWCACQUIRE(6
				, "Day DDW-C Acquire Rank"
				, "일 DDW-C 획득 순위"
				, Arrays.asList(3000, 3000, 4000)
				, Arrays.asList("번호","유저번호","획득한 DDW-C")
				, Arrays.asList("no", "_id", "gold"))
		, DAYDDWCCONSUME(7
				, "Day DDW-C Consume Rank"
				, "일 DDW-C 소모 순위"
				, Arrays.asList(3000, 3000, 4000)
				, Arrays.asList("번호","유저번호","소모한 DDW-C")
				, Arrays.asList("no", "_id", "gold"))
		;

		private int value;
		private String logType;
		private String logTypeKor;
		private List<Integer> colWidths;
		private List<String> colNames;
		private List<String> insNames;

		private statisticType(int value, String logType, String logTypeKor, List<Integer> colWidths, List<String> colNames, List<String> insNames) {
			this.value = value;
			this.logType = logType;
			this.logTypeKor = logTypeKor;
			this.colWidths = colWidths;
			this.colNames = colNames;
			this.insNames = insNames;
		}

		public static statisticType fromValue(int value) {
			for (statisticType type : values()) {
				if (type.value == value)
					return type;
			}
			return DEFAULT;
		}

		public static statisticType fromLogtype(String logType) {
			for (statisticType type : values()) {
				if (type.logType.equals(logType))
					return type;
			}
			return DEFAULT;
		}

		public int getValue() {
			return this.value;
		}
		public String getlogType() {
			return this.logType;
		}
		public String getlogTypeKor() {
			return this.logTypeKor;
		}
		public List<Integer> getColWidths() {
			return this.colWidths;
		}
		public List<String> getColNames() {
			return this.colNames;
		}
		public List<String> getInsNames() {
			return this.insNames;
		}
	}

	// 지갑 거래 타입
	public static enum WalletType {
		SYNC((byte)0)			// 지갑연동
		, DEPOSIT((byte)1)		// 입금 (지갑->게임) Deposit
		, CLAIM((byte)2)		// 출금 (게임->지갑) Claim
		;
		private byte value;
		private WalletType(byte value) { this.value = value; }

		public byte getValue() { return this.value; }
		public static WalletType fromValue(byte value) {
			for(WalletType type : values()) {
				if(type.value == value)
					return type;
			}
			return null;
		}
	}

	// 재화 타입
	public enum PriceType {
		NONE(0)		// None
		, GOLD(1)		// 게임머니
		, NFT(2)		// NFT(이더리움)
		, CASH(3)		// 캐쉬
		, Energy(4)	// 에너지
		, MONEY(5)	// 실제 현금
		;

		private byte value;
		private PriceType(int value) {this.value = (byte)value;}

		public byte getValue() {return this.value;}
		public static PriceType fromValue(byte value) {
			for (PriceType type : values()) {
				if (type.value == value)
					return type;
			}
			return NONE;
		}
	}

	public static enum Period {
		DEFAULT(0, "0 0 4 * * *", TIME_DAY, "1일"),
		DAY(1, "0 0 4 * * *", TIME_DAY, "1일"),
		WEEK(2, "0 0 4 ? * SUN", TIME_WEEK, "1주"),
		MONTH(3, "0 0 4 1 * *", TIME_MONTH, "1달"),
		MINUTE(4, "0 0/1 * * * *", TIME_MIN, "1분"), //테스트용 1분
		SECONDS(5, "0/2 * * * * *", 2, "1초"), //테스트용 1 초
		;
		private byte value;
		private String period;
		private int time;
		private String details;


		private Period(int value, String period, int time, String details) {
			this.value = (byte) value;
			this.period = period;
			this.time = time;
			this.details = details;

		}

		public static Period fromValue(byte value) {
			for (Period type : values()) {
				if (type.value == value)
					return type;
			}
			return DEFAULT;
		}

		public static Period fromPeriod(String period) {
			for (Period type : values()) {
				if (type.period.equals(period))
					return type;
			}
			return DEFAULT;
		}

		public int getValue() {
			return this.value;
		}

		public int getTime() {
			return this.time;
		}

		public String getDetails() {
			return this.details;
		}

	}
}