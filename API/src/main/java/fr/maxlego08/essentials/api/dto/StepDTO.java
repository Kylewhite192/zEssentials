package fr.maxlego08.essentials.api.dto;

import java.util.Date;
import java.util.UUID;

public record StepDTO(UUID unique_id, String step_name, String data, Date created_at, Date updated_at,
                      long play_time_start, long play_time_end, long play_time_between, Date finished_at) {
}
