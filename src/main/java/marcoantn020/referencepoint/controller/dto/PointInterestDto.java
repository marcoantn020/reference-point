package marcoantn020.referencepoint.controller.dto;

import marcoantn020.referencepoint.entity.PintOfInterest;

public record PointInterestDto(String name,
                               Long x_axis,
                               Long y_axis) {

    public PintOfInterest toEntity() {
        return new PintOfInterest(
                name,
                x_axis,
                y_axis
        );
    }
}
