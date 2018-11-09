package org.microprofileext.config.example;

import java.util.logging.Level;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import lombok.extern.java.Log;
import org.microprofileext.config.event.ChangeEvent;
import org.microprofileext.config.event.Type;
import org.microprofileext.config.event.KeyFilter;
import org.microprofileext.config.event.SourceFilter;
import org.microprofileext.config.event.TypeFilter;

/**
 * Example Listener for changes in the events
 * @author <a href="mailto:phillip.kruger@phillip-kruger.com">Phillip Kruger</a>
 */
@Log
@RequestScoped
public class EventChangeListener {

    // Getting all config event
    public void all(@Observes ChangeEvent changeEvent){
        log.log(Level.SEVERE, "ALL: Received a config change event: {0}", changeEvent);
    }
    
    // Get only new values
    public void newValue(@Observes @TypeFilter(Type.NEW) ChangeEvent changeEvent){
        log.log(Level.SEVERE, "NEW: Received a config change event: {0}", changeEvent);
    }
    
    // Get only override values
    public void overrideValue(@Observes @TypeFilter(Type.OVERRIDE) ChangeEvent changeEvent){
        log.log(Level.SEVERE, "OVERRIDE: Received a config change event: {0}", changeEvent);
    }
    
    // Get only revert values
    public void revertValue(@Observes @TypeFilter(Type.REVERT) ChangeEvent changeEvent){
        log.log(Level.SEVERE, "REVERT: Received a config change event: {0}", changeEvent);
    }
    
    // Getting all config event when key is some.key
    public void allForKey(@Observes @KeyFilter("some.key") ChangeEvent changeEvent){
        log.log(Level.SEVERE, "ALL for key [some.key]: Received a config change event: {0}", changeEvent);
    }
    
    // Getting all config event when key is some.key for new events
    public void newForKey(@Observes @TypeFilter(Type.NEW) @KeyFilter("some.key") ChangeEvent changeEvent){
        log.log(Level.SEVERE, "NEW for key [some.key]: Received a config change event: {0}", changeEvent);
    }
    
    // Getting all config event when key is some.key for override events
    public void overrideForKey(@Observes @TypeFilter(Type.OVERRIDE) @KeyFilter("some.key") ChangeEvent changeEvent){
        log.log(Level.SEVERE, "OVERRIDE for key [some.key]: Received a config change event: {0}", changeEvent);
    }
    
    // Getting all config event when key is some.key for revert events
    public void revertForKey(@Observes @TypeFilter(Type.REVERT) @KeyFilter("some.key") ChangeEvent changeEvent){
        log.log(Level.SEVERE, "REVERT for key [some.key]: Received a config change event: {0}", changeEvent);
    }
    
    // Getting all config events for a certain source
    public void allForSource(@Observes @SourceFilter("MemoryConfigSource") ChangeEvent changeEvent){
        log.log(Level.SEVERE, "ALL for source [MemoryConfigSource]: Received a config change event: {0}", changeEvent);
    }
    
    // Getting all config events for a certain source
    public void allForSourceAndKey(@Observes @SourceFilter("MemoryConfigSource") @KeyFilter("some.key")  ChangeEvent changeEvent){
        log.log(Level.SEVERE, "ALL for source [MemoryConfigSource] and for key [some.key]: Received a config change event: {0}", changeEvent);
    }
    
    // Getting all config events for a certain source
    public void overrideForSourceAndKey(@Observes @TypeFilter(Type.OVERRIDE) @SourceFilter("MemoryConfigSource") @KeyFilter("some.key")  ChangeEvent changeEvent){
        log.log(Level.SEVERE, "OVERRIDE for source [MemoryConfigSource] and for key [some.key]: Received a config change event: {0}", changeEvent);
    }
}
