package org.sandha.store;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

public class HeavyResource {
    public HeavyResource(){
        System.out.println("Initializing HeavyResource");
    }
}
