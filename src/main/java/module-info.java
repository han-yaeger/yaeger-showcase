module yaeger.showcase {
    requires hanyaeger;

    exports nl.han.showcase;
    exports nl.han.showcase.scenes.mapsandlegends.tilemaps.entities;
    exports nl.han.showcase.scenes.gravity.tilemaps.entities;
    exports nl.han.showcase.scenes.scrollingstones.entities.game;

    opens audio;
    opens backgrounds;
    opens entities;
    opens fonts;
}
