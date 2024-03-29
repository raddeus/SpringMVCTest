package com.thadb.springmvctest.enums;

public enum ChampionType {
		AHRI("Ahri"),
		AKALI("Akali"),
		ALISTAR("Alistar"),
		AMUMU("Amumu"),
		ANIVIA("Anivia"),
		ANNIE("Annie"),
		ASHE("Ashe"),
		BLITZCRANK("Blitzcrank"),
		BRAND("Brand"),
		CAITLYN("Caitlyn"),
		CASSIOPEIA("Cassiopeia"),
		CHOGATH("Chogath"),
		CORKI("Corki"),
		DARIUS("Darius"),
		DIANA("Diana"),
		DR_MUNDO("Dr. Mundo"),
		DRAVEN("Draven"),
		ELISE("Elise"),
		EVELYNN("Evelynn"),
		EZREAL("Ezreal"),
		FIDDLESTICKS("Fiddlesticks"),
		FIORA("Fiora"),
		FIZZ("Fizz"),
		GALIO("Galio"),
		GANGPLANK("Gangplank"),
		GAREN("Garen"),
		GRAGAS("Gragas"),
		GRAVES("Graves"),
		HECARIM("Hecarim"),
		HEIMERDINGER("Heimerdinger"),
		IRELIA("Irelia"),
		JANNA("Janna"),
		JARVAN_IV("Jarvan IV"),
		JAX("Jax"),
		JAYCE("Jayce"),
		KARMA("Karma"),
		KARTHUS("Karthus"),
		KASSADIN("Kassadin"),
		KATARINA("Katarina"),
		KAYLE("Kayle"),
		KENNEN("Kennen"),
		KHAZIX("Kha'Zix"),
		KOGMAW("Kogmaw"),
		LEBLANC("Leblanc"),
		LEE_SIN("Lee Sin"),
		LEONA("Leona"),
		LULU("Lulu"),
		LUX("Lux"),
		MALPHITE("Malphite"),
		MALZAHAR("Malzahar"),
		MAOKAI("Maokai"),
		MASTER_YI("Master Yi"),
		MISS_FORTUNE("Miss Fortune"),
		MORDEKAISER("Mordekaiser"),
		MORGANA("Morgana"),
		NASUS("Nasus"),
		NAUTILUS("Nautilus"),
		NIDALEE("Nidalee"),
		NOCTURNE("Nocturne"),
		NUNU("Nunu"),
		OLAF("Olaf"),
		ORIANNA("Orianna"),
		PANTHEON("Pantheon"),
		POPPY("Poppy"),
		RAMMUS("Rammus"),
		RENEKTON("Renekton"),
		RENGAR("Rengar"),
		RIVEN("Riven"),
		RUMBLE("Rumble"),
		RYZE("Ryze"),
		SEJUANI("Sejuani"),
		SHACO("Shaco"),
		SHEN("Shen"),
		SHYVANA("Shyvana"),
		SINGED("Singed"),
		SION("Sion"),
		SIVIR("Sivir"),
		SKARNER("Skarner"),
		SONA("Sona"),
		SORAKA("Soraka"),
		SWAIN("Swain"),
		SYNDRA("Syndra"),
		TALON("Talon"),
		TARIC("Taric"),
		TEEMO("Teemo"),
		TRISTANA("Tristana"),
		TRUNDLE("Trundle"),
		TRYNDAMERE("Tryndamere"),
		TWISTED_FATE("Twisted Fate"),
		TWITCH("Twitch"),
		UDYR("Udyr"),
		URGOT("Urgot"),
		VARUS("Varus"),
		VAYNE("Vayne"),
		VEIGAR("Veigar"),
		VIKTOR("Viktor"),
		VLADIMIR("Vladimir"),
		VOLIBEAR("Volibear"),
		WARWICK("Warwick"),
		WUKONG("Wukong"),
		XERATH("Xerath"),
		XIN_ZHAO("Xin Zhao"),
		YORICK("Yorick"),
		ZIGGS("Ziggs"),
		ZILEAN("Zilean"),
		ZYRA("Zyra"),
		ZED("Zed");

    private String displayName;
    
private ChampionType(String displayName)
{
this.displayName = displayName;
}

public String getDisplayName()
{
return displayName;
}

public String getName(){
	return this.name();
}

}
