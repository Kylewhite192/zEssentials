package fr.maxlego08.essentials.migrations.create;

import fr.maxlego08.sarah.database.Migration;

public class CreateUserPlayTimeTableMigration extends Migration {
    @Override
    public void up() {
        create("%prefix%user_play_times", table -> {
            table.uuid("unique_id").foreignKey("%prefix%users");
            table.bigInt("play_time");
            table.string("address", 255);
            table.timestamps();
        });
    }
}
