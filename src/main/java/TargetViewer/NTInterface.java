package TargetViewer;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.EntryListenerFlags;

public class NTInterface {
    NetworkTableInstance inst = NetworkTableInstance.getDefault();
    NetworkTable table;

    NetworkTableEntry fov_listener;
    NetworkTableEntry distance_listener;
    NetworkTableEntry angle_listener;

    double fov = 0.0;
    double angle = 0.0;
    double distance = 0.0;

    public NTInterface(String table, int team) {
        this.table = inst.getTable(table);

        this.fov_listener = this.table.getEntry("camera_fov");
        this.distance_listener = this.table.getEntry("target_distance");
        this.angle_listener = this.table.getEntry("target_angle");

        inst.startClientTeam(team);
    }

    public void start() {
        this.fov_listener.addListener(event -> {
            this.fov = event.value.getDouble();
        }, EntryListenerFlags.kNew | EntryListenerFlags.kUpdate);

        this.distance_listener.addListener(event -> {
            this.distance = event.value.getDouble();
        }, EntryListenerFlags.kNew | EntryListenerFlags.kUpdate);

        this.angle_listener.addListener(event -> {
            this.angle = event.value.getDouble();
        }, EntryListenerFlags.kNew | EntryListenerFlags.kUpdate);
    }

    public double getFOV() {
        return this.fov;
    }

    public double getDistance() {
        return this.distance;
    }
    
    public double getAngle() {
        return this.angle;
    }
    
}