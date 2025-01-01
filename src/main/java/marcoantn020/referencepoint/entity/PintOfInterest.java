package marcoantn020.referencepoint.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_point_interest")
public class PintOfInterest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long x_axis;

    private Long y_axis;

    public PintOfInterest() {
    }

    public PintOfInterest(String name, Long x_axis, Long y_axis) {
        this.name = name;
        this.x_axis = x_axis;
        this.y_axis = y_axis;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getX_axis() {
        return x_axis;
    }

    public void setX_axis(Long x_axis) {
        this.x_axis = x_axis;
    }

    public Long getY_axis() {
        return y_axis;
    }

    public void setY_axis(Long y_axis) {
        this.y_axis = y_axis;
    }
}
