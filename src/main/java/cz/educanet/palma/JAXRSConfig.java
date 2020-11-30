package cz.educanet.palma;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/api") // localhost:8080/nazev-appky/api/[resource]

public class JAXRSConfig extends Application {
}
