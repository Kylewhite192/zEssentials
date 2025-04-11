package fr.maxlego08.essentials.commands.commands.spawn;

import fr.maxlego08.essentials.api.EssentialsPlugin;
import fr.maxlego08.essentials.api.commands.CommandResultType;
import fr.maxlego08.essentials.api.commands.Permission;
import fr.maxlego08.essentials.api.messages.Message;
import fr.maxlego08.essentials.api.utils.SafeLocation;
import fr.maxlego08.essentials.module.modules.SpawnModule;
import fr.maxlego08.essentials.storage.ConfigStorage;
import fr.maxlego08.essentials.zutils.utils.commands.VCommand;
import org.bukkit.Location;

public class CommandSetFirstSpawn extends VCommand {

    public CommandSetFirstSpawn(EssentialsPlugin plugin) {
        super(plugin);
        this.setModule(SpawnModule.class);
        this.setPermission(Permission.ESSENTIALS_SET_FIRST_SPAWN);
        this.setDescription(Message.DESCRIPTION_SET_FIRST_SPAWN);
        this.onlyPlayers();
    }

    @Override
    protected CommandResultType perform(EssentialsPlugin plugin) {

        Location location = this.player.getLocation();
        /*plugin.getServerStorage().setSpawnLocation(location);
        plugin.getStorageManager().getStorage().upsertStorage("first_spawn_location", locationAsString(location));*/

        ConfigStorage.firstSpawnLocation = new SafeLocation(location.clone());
        ConfigStorage.getInstance().save(plugin.getPersist());

        message(sender, Message.COMMAND_SET_SPAWN);

        return CommandResultType.SUCCESS;
    }
}
