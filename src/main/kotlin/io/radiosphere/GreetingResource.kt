package io.radiosphere

import io.quarkus.runtime.StartupEvent
import org.infinispan.client.hotrod.DefaultTemplate
import org.infinispan.client.hotrod.RemoteCacheManager
import org.jboss.logging.Logger
import javax.enterprise.event.Observes
import javax.inject.Inject
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/hello")
class GreetingResource {

    @Inject
    lateinit var cacheManager: RemoteCacheManager


    val logger = Logger.getLogger(this.javaClass)

    fun onStartup(@Observes startupEvent: StartupEvent) {
        val cache = cacheManager.administration().getOrCreateCache<String, CounterState>("default", DefaultTemplate.DIST_SYNC)

        cache.put("a", CounterState(2L))
        val state = cache.get("a")

        logger.info("State: ${state}")

    }
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    fun hello(): String {

        return "Hello RESTEasy"
    }
}