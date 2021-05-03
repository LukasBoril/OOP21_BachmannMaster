package ch.zhaw.exercise.le08b.console.mvc.domain;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Observable;

public class StudentModel {
    private String name;

    public StudentModel(int id, String name) {
        this.name = name;
    }

    private final PropertyChangeSupport changes = new PropertyChangeSupport( this );

    public String getName() {
        return name;
    }

    public void setName(String name) {

        String oldName = this.name;
        this.name = name;
        changes.firePropertyChange( "name", oldName, name );
    }

    public void addPropertyChangeListener( PropertyChangeListener listener ) {
        changes.addPropertyChangeListener( listener );
    }

    public void removePropertyChangeListener( PropertyChangeListener listener ) {
        changes.removePropertyChangeListener( listener );
    }

}
