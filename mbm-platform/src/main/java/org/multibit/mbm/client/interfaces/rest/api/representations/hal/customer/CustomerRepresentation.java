package org.multibit.mbm.client.interfaces.rest.api.representations.hal.customer;

import com.google.common.base.Preconditions;
import com.theoryinpractise.halbuilder.DefaultRepresentationFactory;
import com.theoryinpractise.halbuilder.api.Representation;
import com.theoryinpractise.halbuilder.api.RepresentationFactory;
import org.multibit.mbm.client.domain.model.model.Customer;

/**
 * <p>Representation to provide the following to {@link org.multibit.mbm.client.domain.model.model.Customer}:</p>
 * <ul>
 * <li>Creates {@link Representation} representations</li>
 * </ul>
 *
 * @since 0.0.1
 */
public class CustomerRepresentation {

  public Representation get(Customer customer) {
    Preconditions.checkNotNull(customer, "customer");
    Preconditions.checkNotNull(customer.getId(), "id");

    String basePath = "/customer/" + customer.getId();

    // Create top-level resource
    RepresentationFactory factory = new DefaultRepresentationFactory();
    return factory
      .newRepresentation(basePath)
      .withLink("user", "/user/" + customer.getUser().getId())
      .withLink("cart", "/cart/" + customer.getCart().getId());
  }

}
