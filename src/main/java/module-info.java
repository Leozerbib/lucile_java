module Isep.a1.JO.PlanningJO {
    requires javafx.controls;
    requires javafx.fxml;
	requires java.sql;
	requires lombok;
	requires javafx.graphics;
	requires javafx.base;

    opens Isep.a1.JO.PlanningJO to javafx.fxml;
    exports Isep.a1.JO.PlanningJO;
    exports Isep.a1.JO.PlanningJO.Controler.fx;
}
