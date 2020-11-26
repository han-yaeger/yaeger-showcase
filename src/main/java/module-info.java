module yaeger.showcase {
    requires hanyaeger.api;

    exports nl.han.showcase;
    exports nl.han.showcase.scenes.mapsandlegends.tilemaps.entities;
    exports nl.han.showcase.scenes.gravity.maps.ground;
    exports nl.han.showcase.scenes.gravity.maps.other;
    exports nl.han.showcase.scenes.gravity.maps.totems;

    opens audio;
    opens backgrounds;
    opens entities;
    opens entities.forrest.walls;
    opens entities.forrest.other;
    opens entities.forrest.totems;
}
