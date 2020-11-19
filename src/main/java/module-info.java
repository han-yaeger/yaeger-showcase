module yaeger.showcase {
    requires hanyaeger.api;

    exports nl.han.showcase;
    exports nl.han.showcase.scenes.mapsandlegends.tilemaps.entities;
    exports nl.han.showcase.scenes.gravity.entities.walls;
    exports nl.han.showcase.scenes.gravity.entities.other;

    opens audio;
    opens backgrounds;
    opens entities;
    opens entities.forrest.walls;
    opens entities.forrest.other;
}
