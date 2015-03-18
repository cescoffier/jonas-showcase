# The Shop #
The Shop (shop-ear) is the core of the application. It's an EAR composed by a servlet (WAR file), and an EJB. This EJB uses product providers exposed as OSGi service.

# Product Providers #
There is two types of product providers.

## OSGi services ##
Such providers are "regular" OSGi services. In the showcase, they are implemented thanks to the iPOJO component model. They just expose the adequate service inside the OSGi service registry.

The coffee provider and tee provider follows this model.

## EJB exposed as OSGi service ##
Thanks to JOnAS, it is possible to expose the local interface of EJB as an OSGi service.

The milk provider and sugar provider follows this model.