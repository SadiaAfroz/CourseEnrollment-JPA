package net.therap.view;

import java.util.Set;

/**
 * @author sadia.afroz
 * @since 4/18/21
 */
public interface DetailsView<T> {

    void view(Set<T> list);
}
