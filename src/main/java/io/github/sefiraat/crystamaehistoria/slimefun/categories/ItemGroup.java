package io.github.sefiraat.crystamaehistoria.slimefun.categories;

import io.github.sefiraat.crystamaehistoria.CrystamaeHistoria;
import io.github.sefiraat.crystamaehistoria.theme.ThemeType;
import io.github.sefiraat.crystamaehistoria.utils.ThemeUtils;
import io.github.thebusybiscuit.slimefun4.api.items.groups.NestedItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.groups.SubItemGroup;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class ItemGroup {

    private final CrystamaeHistoria plugin;

    public final NestedItemGroup MAIN = new NestedItemGroup(CrystamaeHistoria.inst().getKeyHolder().getCatMain(), new CustomItemStack(
            new ItemStack(Material.AMETHYST_CLUSTER),
            ThemeUtils.getThemeColor(ThemeType.MAIN) + "Crystamae Historia"
    ));
    public final SubItemGroup MECHANISMS = new SubItemGroup(CrystamaeHistoria.inst().getKeyHolder().getCatMechanical(), MAIN, new CustomItemStack(
            new ItemStack(Material.DEEPSLATE_TILE_SLAB),
            ThemeUtils.getThemeColor(ThemeType.MAIN) + "Historia Mechanisms"
    ));
    public final SubItemGroup CRYSTALS = new SubItemGroup(CrystamaeHistoria.inst().getKeyHolder().getCatCrystal(), MAIN, new CustomItemStack(
            new ItemStack(Material.AMETHYST_CLUSTER),
            ThemeUtils.getThemeColor(ThemeType.MAIN) + "Historia Crystals"
    ));

    public ItemGroup(CrystamaeHistoria plugin) {
        this.plugin = plugin;
    }

    public void setup() {
        MAIN.register(plugin);
        MECHANISMS.register(plugin);
    }

}