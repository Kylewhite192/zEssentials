package fr.maxlego08.essentials.buttons.vault;

import fr.maxlego08.essentials.api.EssentialsPlugin;
import fr.maxlego08.essentials.api.vault.PlayerVaults;
import fr.maxlego08.essentials.api.vault.Vault;
import fr.maxlego08.menu.api.button.Button;
import fr.maxlego08.menu.api.engine.InventoryEngine;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class ButtonVaultSlotDisable extends Button {

    private final EssentialsPlugin plugin;

    public ButtonVaultSlotDisable(Plugin plugin) {
        this.plugin = (EssentialsPlugin) plugin;
    }

    @Override
    public boolean hasSpecialRender() {
        return true;
    }

    @Override
    public void onRender(Player player, InventoryEngine inventory) {
        var manager = this.plugin.getVaultManager();
        PlayerVaults playerVaults = manager.getPlayerVaults(player);
        Vault vault = playerVaults.getTargetVault();
        if (vault == null) return;

        int current = vault.getVaultId();
        int startSlot = manager.getMaxSlotsPlayer(player) - (this.slots.size() * (vault.getVaultId() - 1));
        if (startSlot > this.slots.size() * current) return;

        for (int index = Math.max(0, startSlot); index < this.slots.size(); index++) {

            int slot = this.slots.get(index);
            inventory.addItem(slot, this.getItemStack().build(player));
        }
    }
}
