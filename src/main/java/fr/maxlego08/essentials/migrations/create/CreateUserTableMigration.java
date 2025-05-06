package fr.maxlego08.essentials.migrations.create;

import fr.maxlego08.sarah.database.Migration;

public class CreateUserTableMigration extends Migration {
    @Override
    public void up() {
        create("%prefix%users", table -> {
            table.uuid("unique_id").primary();
            table.string("name", 16);
            table.text("last_location").nullable();
            table.bigInt("play_time").defaultValue("0");
            table.timestamps();
        });
    }
}
