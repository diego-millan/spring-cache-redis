package com.diegomillan.cachingdemo.model;

import java.io.Serializable;

public record Product (Long id, String name, String description) implements Serializable {
}
