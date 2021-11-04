package io.github.sefiraat.crystamaehistoria.slimefun;

import io.github.sefiraat.crystamaehistoria.CrystamaeHistoria;
import io.github.sefiraat.crystamaehistoria.slimefun.mechanisms.chroniclerpanel.ChroniclerPanel;
import io.github.sefiraat.crystamaehistoria.slimefun.mechanisms.gadgets.MobFan;
import io.github.sefiraat.crystamaehistoria.slimefun.mechanisms.gadgets.MobLamp;
import io.github.sefiraat.crystamaehistoria.slimefun.mechanisms.liquefactionbasin.DummyLiquefactionBasinCrafting;
import io.github.sefiraat.crystamaehistoria.slimefun.mechanisms.liquefactionbasin.LiquefactionBasin;
import io.github.sefiraat.crystamaehistoria.slimefun.mechanisms.liquefactionbasin.LiquefactionBasinCache;
import io.github.sefiraat.crystamaehistoria.slimefun.mechanisms.liquefactionbasin.RecipeItem;
import io.github.sefiraat.crystamaehistoria.slimefun.mechanisms.realisationaltar.RealisationAltar;
import io.github.sefiraat.crystamaehistoria.slimefun.mechanisms.staveconfigurator.StaveConfigurator;
import io.github.sefiraat.crystamaehistoria.stories.definition.StoryType;
import io.github.sefiraat.crystamaehistoria.utils.theme.ThemeType;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import lombok.Getter;
import lombok.experimental.UtilityClass;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

@UtilityClass
public class Mechanisms {

    @Getter
    private static ChroniclerPanel chroniclerPanel1;
    @Getter
    private static ChroniclerPanel chroniclerPanel2;
    @Getter
    private static ChroniclerPanel chroniclerPanel3;
    @Getter
    private static ChroniclerPanel chroniclerPanel4;
    @Getter
    private static RealisationAltar realisationAltar1;
    @Getter
    private static RealisationAltar realisationAltar2;
    @Getter
    private static RealisationAltar realisationAltar3;
    @Getter
    private static RealisationAltar realisationAltar4;
    @Getter
    private static LiquefactionBasin liquefactionBasin1;
    @Getter
    private static LiquefactionBasin liquefactionBasin2;
    @Getter
    private static LiquefactionBasin liquefactionBasin3;
    @Getter
    private static LiquefactionBasin liquefactionBasin4;
    @Getter
    private static StaveConfigurator staveConfigurator;
    @Getter
    private static MobLamp abstractionLamp;
    @Getter
    private static MobLamp dispersionLamp;
    @Getter
    private static MobFan inversionVacuum;
    @Getter
    private static MobFan antipodalVacuum;

    public static void setup() {

        final CrystamaeHistoria plugin = CrystamaeHistoria.getInstance();

        // Chronicler Tier 1
        chroniclerPanel1 = new ChroniclerPanel(
            ItemGroups.MECHANISMS,
            ThemeType.themedSlimefunItemStack(
                "CRY_CHRONICLER_PANEL_1",
                new ItemStack(Material.COBBLED_DEEPSLATE_SLAB),
                ThemeType.MECHANISM,
                "Chronicler Panel (Tier 1)",
                "The chronicler panel will draw out",
                "the stories contained within a given",
                "block over time.",
                "",
                "Can chronicle stories for T1-T2 blocks."
            ),
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[]{
                new ItemStack(Material.COBBLED_DEEPSLATE), new ItemStack(Material.COBBLED_DEEPSLATE), new ItemStack(Material.COBBLED_DEEPSLATE),
                SlimefunItems.CORINTHIAN_BRONZE_INGOT, new ItemStack(Material.AMETHYST_CLUSTER), SlimefunItems.CORINTHIAN_BRONZE_INGOT,
                SlimefunItems.MAGIC_LUMP_2, SlimefunItems.MAGIC_LUMP_2, SlimefunItems.MAGIC_LUMP_2,
            },
            1
        );

        // Chronicler Tier 2
        chroniclerPanel2 = new ChroniclerPanel(
            ItemGroups.MECHANISMS,
            ThemeType.themedSlimefunItemStack(
                "CRY_CHRONICLER_PANEL_2",
                new ItemStack(Material.DEEPSLATE_TILE_SLAB),
                ThemeType.MECHANISM,
                "Chronicler Panel (Tier 2)",
                "The chronicler panel will draw out",
                "the stories contained within a given",
                "block over time.",
                "",
                "Can chronicle stories for T1-T3 blocks."
            ),
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[]{
                new ItemStack(Material.DEEPSLATE_BRICKS),           new ItemStack(Material.DEEPSLATE_BRICKS),   new ItemStack(Material.DEEPSLATE_BRICKS),
                Materials.getAmalgamateIngotUncommon().getItem(),   chroniclerPanel1.getItem(),                 Materials.getAmalgamateIngotUncommon().getItem(),
                SlimefunItems.MAGIC_LUMP_3,                         SlimefunItems.MAGIC_LUMP_3,                 SlimefunItems.MAGIC_LUMP_3,
            },
            2
        );

        // Chronicler Tier 3
        RecipeItem chroniclerT3Recipe = new RecipeItem(
            chroniclerPanel2.getItem(),
            StoryType.ELEMENTAL, 150,
            StoryType.CELESTIAL, 200,
            StoryType.VOID, 50
        );
        chroniclerPanel3 = new ChroniclerPanel(
            ItemGroups.MECHANISMS,
            ThemeType.themedSlimefunItemStack(
                "CRY_CHRONICLER_PANEL_3",
                new ItemStack(Material.NETHER_BRICK_SLAB),
                ThemeType.MECHANISM,
                "Chronicler Panel (Tier 3)",
                "The chronicler panel will draw out",
                "the stories contained within a given",
                "block over time.",
                "",
                "Can chronicle stories for T1-T4 blocks."
            ),
            DummyLiquefactionBasinCrafting.TYPE,
            chroniclerT3Recipe.getDisplayRecipe(),
            3
        );

        // Chronicler Tier 4
        RecipeItem chroniclerT4Recipe = new RecipeItem(
            chroniclerPanel3.getItem(),
            StoryType.ELEMENTAL, 1000,
            StoryType.CELESTIAL, 850,
            StoryType.VOID, 650
        );
        chroniclerPanel4 = new ChroniclerPanel(
            ItemGroups.MECHANISMS,
            ThemeType.themedSlimefunItemStack(
                "CRY_CHRONICLER_PANEL_4",
                new ItemStack(Material.DARK_PRISMARINE_SLAB),
                ThemeType.MECHANISM,
                "Chronicler Panel (Tier 4)",
                "The chronicler panel will draw out",
                "the stories contained within a given",
                "block over time.",
                "",
                "Can chronicle stories for T1-T5 blocks."
            ),
            DummyLiquefactionBasinCrafting.TYPE,
            chroniclerT4Recipe.getDisplayRecipe(),
            4
        );

        // Realisation Tier 1
        realisationAltar1 = new RealisationAltar(
            ItemGroups.MECHANISMS,
            ThemeType.themedSlimefunItemStack(
                "CRY_REALISATION_ALTAR_1",
                new ItemStack(Material.CHISELED_DEEPSLATE),
                ThemeType.MECHANISM,
                "Realisation Altar (Tier 1)",
                "The realisation altar takes storied",
                "blocks and converts their stories into",
                "a physical form.",
                "",
                "Can realise T1 - T2."
            ),
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[]{
                null, new ItemStack(Material.BOOK), null,
                SlimefunItems.CORINTHIAN_BRONZE_INGOT, new ItemStack(Material.AMETHYST_CLUSTER), SlimefunItems.CORINTHIAN_BRONZE_INGOT,
                SlimefunItems.MAGIC_LUMP_2, SlimefunItems.COMMON_TALISMAN, SlimefunItems.MAGIC_LUMP_2,
            },
            1
        );

        // Realisation Tier 2
        realisationAltar2 = new RealisationAltar(
            ItemGroups.MECHANISMS,
            ThemeType.themedSlimefunItemStack(
                "CRY_REALISATION_ALTAR_2",
                new ItemStack(Material.CHISELED_NETHER_BRICKS),
                ThemeType.MECHANISM,
                "Realisation Altar (Tier 2)",
                "The realisation altar takes storied",
                "blocks and converts their stories into",
                "a physical form.",
                "",
                "Can realise T1 - T3."
            ),
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[]{
                null,                                               new ItemStack(Material.BOOK),  null,
                Materials.getAmalgamateIngotUncommon().getItem(),   realisationAltar1.getItem(),   Materials.getAmalgamateIngotUncommon().getItem(),
                SlimefunItems.MAGIC_LUMP_3,                         SlimefunItems.SOULBOUND_RUNE,  SlimefunItems.MAGIC_LUMP_3,
            },
            2
        );

        // Realisation Tier 3
        RecipeItem realisationT3Recipe = new RecipeItem(
            realisationAltar2.getItem(),
            StoryType.HISTORICAL, 100,
            StoryType.HUMAN, 350,
            StoryType.PHILOSOPHICAL, 150
        );
        realisationAltar3 = new RealisationAltar(
            ItemGroups.MECHANISMS,
            ThemeType.themedSlimefunItemStack(
                "CRY_REALISATION_ALTAR_3",
                new ItemStack(Material.CHISELED_RED_SANDSTONE),
                ThemeType.MECHANISM,
                "Realisation Altar (Tier 3)",
                "The realisation altar takes storied",
                "blocks and converts their stories into",
                "a physical form.",
                "",
                "Can realise T1 - T4."
            ),
            DummyLiquefactionBasinCrafting.TYPE,
            realisationT3Recipe.getDisplayRecipe(),
            3
        );

        // Realisation Tier 4
        RecipeItem realisationT4Recipe = new RecipeItem(
            realisationAltar3.getItem(),
            StoryType.HISTORICAL, 1100,
            StoryType.HUMAN, 720,
            StoryType.PHILOSOPHICAL, 450
        );
        realisationAltar4 = new RealisationAltar(
            ItemGroups.MECHANISMS,
            ThemeType.themedSlimefunItemStack(
                "CRY_REALISATION_ALTAR_4",
                new ItemStack(Material.CHISELED_POLISHED_BLACKSTONE),
                ThemeType.MECHANISM,
                "Realisation Altar (Tier 4)",
                "The realisation altar takes storied",
                "blocks and converts their stories into",
                "a physical form.",
                "",
                "Can realise T1 - T5."
            ),
            DummyLiquefactionBasinCrafting.TYPE,
            realisationT4Recipe.getDisplayRecipe(),
            4
        );

        // Liquefaction T1
        liquefactionBasin1 = new LiquefactionBasin(
            ItemGroups.MECHANISMS,
            ThemeType.themedSlimefunItemStack(
                "CRY_LIQUEFACTION_BASIN_1",
                new ItemStack(Material.CAULDRON),
                ThemeType.MECHANISM,
                "Liquefaction Basin (Tier 1)",
                "The liquefaction basin can take",
                "Crystals and convert them into their liquid",
                "Crystamae form. Used for magical crafting",
                "",
                "Holds up to 500 Liquefied Crysta."
            ),
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[]{
                SlimefunItems.REINFORCED_ALLOY_INGOT, null,                             SlimefunItems.REINFORCED_ALLOY_INGOT,
                SlimefunItems.REINFORCED_ALLOY_INGOT, new ItemStack(Material.CAULDRON), SlimefunItems.REINFORCED_ALLOY_INGOT,
                SlimefunItems.REINFORCED_ALLOY_INGOT, SlimefunItems.COMMON_TALISMAN,    SlimefunItems.REINFORCED_ALLOY_INGOT
            },
            500
        );

        // Liquefaction T2
        liquefactionBasin2 = new LiquefactionBasin(
            ItemGroups.MECHANISMS,
            ThemeType.themedSlimefunItemStack(
                "CRY_LIQUEFACTION_BASIN_2",
                new ItemStack(Material.CAULDRON),
                ThemeType.MECHANISM,
                "Liquefaction Basin (Tier 2)",
                "The liquefaction basin can take",
                "Crystals and convert them into their liquid",
                "Crystamae form. Used for magical crafting",
                "",
                "Holds up to 1000 Liquefied Crysta."
            ),
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[]{
                Materials.getAmalgamateDustRare().getItem(), null,                              Materials.getAmalgamateDustRare().getItem(),
                Materials.getAmalgamateDustRare().getItem(), liquefactionBasin1.getItem(),      Materials.getAmalgamateDustRare().getItem(),
                Materials.getAmalgamateDustRare().getItem(), SlimefunItems.ENCHANTMENT_RUNE,    Materials.getAmalgamateDustRare().getItem()
            },
            1000
        );

        // Liquefaction T3
        RecipeItem liquefactionT3Recipe = new RecipeItem(
            liquefactionBasin2.getItem(),
            StoryType.MECHANICAL, 90,
            StoryType.ALCHEMICAL, 250,
            StoryType.ANIMAL, 185
        );
        liquefactionBasin3 = new LiquefactionBasin(
            ItemGroups.MECHANISMS,
            ThemeType.themedSlimefunItemStack(
                "CRY_LIQUEFACTION_BASIN_3",
                new ItemStack(Material.CAULDRON),
                ThemeType.MECHANISM,
                "Liquefaction Basin (Tier 3)",
                "The liquefaction basin can take",
                "Crystals and convert them into their liquid",
                "Crystamae form. Used for magical crafting",
                "",
                "Holds up to 2500 Liquefied Crysta."
            ),
            DummyLiquefactionBasinCrafting.TYPE,
            liquefactionT3Recipe.getDisplayRecipe(),
            2500
        );

        // Liquefaction T4
        RecipeItem liquefactionT4Recipe = new RecipeItem(
            liquefactionBasin3.getItem(),
            StoryType.MECHANICAL, 750,
            StoryType.ALCHEMICAL, 700,
            StoryType.ANIMAL, 600
        );
        liquefactionBasin4 = new LiquefactionBasin(
            ItemGroups.MECHANISMS,
            ThemeType.themedSlimefunItemStack(
                "CRY_LIQUEFACTION_BASIN_4",
                new ItemStack(Material.CAULDRON),
                ThemeType.MECHANISM,
                "Liquefaction Basin (Tier 4)",
                "The liquefaction basin can take",
                "Crystals and convert them into their liquid",
                "Crystamae form. Used for magical crafting",
                "",
                "Holds up to 5000 Liquefied Crysta."
            ),
            DummyLiquefactionBasinCrafting.TYPE,
            liquefactionT4Recipe.getDisplayRecipe(),
            5000
        );

        // Stave Configurator
        RecipeItem staveConfiguratorRecipe = new RecipeItem(
            new ItemStack(Material.COPPER_BLOCK),
            StoryType.ELEMENTAL, 300,
            StoryType.MECHANICAL, 200,
            StoryType.ALCHEMICAL, 510
        );
        staveConfigurator = new StaveConfigurator(
            ItemGroups.MECHANISMS,
            ThemeType.themedSlimefunItemStack(
                "CRY_STAVE_CONFIGURATOR",
                new ItemStack(Material.CUT_COPPER),
                ThemeType.MECHANISM,
                "Stave Configurator",
                "The Stave Configurator allows you",
                "to add spell plates into your",
                "Staves."
            ),
            DummyLiquefactionBasinCrafting.TYPE,
            staveConfiguratorRecipe.getDisplayRecipe()
        );

        // Abstraction Lamp
        RecipeItem abstractionLampRecipe = new RecipeItem(
            new ItemStack(Material.LANTERN),
            StoryType.ALCHEMICAL, 50,
            StoryType.HUMAN, 75,
            StoryType.PHILOSOPHICAL, 75
        );
        abstractionLamp = new MobLamp(
            ItemGroups.MECHANISMS,
            ThemeType.themedSlimefunItemStack(
                "CRY_MOB_LAMP_1",
                new ItemStack(Material.LANTERN),
                ThemeType.MECHANISM,
                "Abstraction Lamp",
                "The abstraction lamp will push all",
                "nearby mobs away from it.",
                "",
                ThemeType.CLICK_INFO.getColor() + "Range: " + ThemeType.PASSIVE.getColor() + "5 Blocks",
                ThemeType.CLICK_INFO.getColor() + "Force: " + ThemeType.PASSIVE.getColor() + "3 CrystaPow™"
            ),
            DummyLiquefactionBasinCrafting.TYPE,
            abstractionLampRecipe.getDisplayRecipe(),
            5,
            0.3
        );

        // Dispersion Lamp
        RecipeItem dispersionLampRecipe = new RecipeItem(
            abstractionLamp.getItem(),
            StoryType.ALCHEMICAL, 250,
            StoryType.HUMAN, 150,
            StoryType.PHILOSOPHICAL, 300
        );
        dispersionLamp = new MobLamp(
            ItemGroups.MECHANISMS,
            ThemeType.themedSlimefunItemStack(
                "CRY_MOB_LAMP_2",
                new ItemStack(Material.SOUL_LANTERN),
                ThemeType.MECHANISM,
                "Dispersion Lamp",
                "The dispersion lamp will push all",
                "nearby mobs away from it.",
                "",
                ThemeType.CLICK_INFO.getColor() + "Range: " + ThemeType.PASSIVE.getColor() + "7 Blocks",
                ThemeType.CLICK_INFO.getColor() + "Force: " + ThemeType.PASSIVE.getColor() + "5 CrystaPow™"
            ),
            DummyLiquefactionBasinCrafting.TYPE,
            abstractionLampRecipe.getDisplayRecipe(),
            7,
            0.5
        );

        // Inversion Vacuum
        RecipeItem inversionVacuumRecipe = new RecipeItem(
            abstractionLamp.getItem(),
            StoryType.HISTORICAL, 200,
            StoryType.VOID, 200,
            StoryType.PHILOSOPHICAL, 180
        );
        inversionVacuum = new MobFan(
            ItemGroups.MECHANISMS,
            ThemeType.themedSlimefunItemStack(
                "CRY_MOB_FAN_1",
                new ItemStack(Material.REDSTONE_LAMP),
                ThemeType.MECHANISM,
                "Inversion Vacuum",
                "Creates a magically induced vacuum",
                "that pulls entities away from the",
                "mechanism.",
                "",
                ThemeType.CLICK_INFO.getColor() + "Push Distance: " + ThemeType.PASSIVE.getColor() + "5 Blocks"
            ),
            DummyLiquefactionBasinCrafting.TYPE,
            inversionVacuumRecipe.getDisplayRecipe(),
            5
        );


        // Antipodal Vacuum
        RecipeItem antipodalVacuumRecipe = new RecipeItem(
            dispersionLamp.getItem(),
            StoryType.HISTORICAL, 400,
            StoryType.VOID, 400,
            StoryType.PHILOSOPHICAL, 360
        );
        antipodalVacuum = new MobFan(
            ItemGroups.MECHANISMS,
            ThemeType.themedSlimefunItemStack(
                "CRY_MOB_FAN_2",
                new ItemStack(Material.NOTE_BLOCK),
                ThemeType.MECHANISM,
                "Antipodal Vacuum",
                "Creates a magically induced vacuum",
                "that pulls entities away from the",
                "mechanism.",
                "",
                ThemeType.CLICK_INFO.getColor() + "Push Distance: " + ThemeType.PASSIVE.getColor() + "10 Blocks"
            ),
            DummyLiquefactionBasinCrafting.TYPE,
            antipodalVacuumRecipe.getDisplayRecipe(),
            10
        );

        // Slimefun Registry
        chroniclerPanel1.register(plugin);
        chroniclerPanel2.register(plugin);
        chroniclerPanel3.register(plugin);
        chroniclerPanel4.register(plugin);
        realisationAltar1.register(plugin);
        realisationAltar2.register(plugin);
        realisationAltar3.register(plugin);
        realisationAltar4.register(plugin);
        liquefactionBasin1.register(plugin);
        liquefactionBasin2.register(plugin);
        liquefactionBasin3.register(plugin);
        liquefactionBasin4.register(plugin);
        staveConfigurator.register(plugin);
        abstractionLamp.register(plugin);
        dispersionLamp.register(plugin);
        inversionVacuum.register(plugin);
        antipodalVacuum.register(plugin);

        // Liquefaction Recipes
        LiquefactionBasinCache.addCraftingRecipe(chroniclerPanel3, chroniclerT3Recipe);
        LiquefactionBasinCache.addCraftingRecipe(chroniclerPanel4, chroniclerT4Recipe);

        LiquefactionBasinCache.addCraftingRecipe(realisationAltar3, realisationT3Recipe);
        LiquefactionBasinCache.addCraftingRecipe(realisationAltar4, realisationT4Recipe);

        LiquefactionBasinCache.addCraftingRecipe(liquefactionBasin3, liquefactionT3Recipe);
        LiquefactionBasinCache.addCraftingRecipe(liquefactionBasin4, liquefactionT4Recipe);

        LiquefactionBasinCache.addCraftingRecipe(staveConfigurator, staveConfiguratorRecipe);

        LiquefactionBasinCache.addCraftingRecipe(abstractionLamp, abstractionLampRecipe);
        LiquefactionBasinCache.addCraftingRecipe(dispersionLamp, dispersionLampRecipe);

        LiquefactionBasinCache.addCraftingRecipe(inversionVacuum, inversionVacuumRecipe);
        LiquefactionBasinCache.addCraftingRecipe(antipodalVacuum, antipodalVacuumRecipe);
    }

}
