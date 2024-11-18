package edu.baylor.ecs.qms.model.supermodel;

import java.io.Serializable;

/**
 * Interface specifies ICPC entity, which has to contain id.
 *
 */
public interface ICPCEntity extends Serializable, Cloneable {

    Long getId();

}

