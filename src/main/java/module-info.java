module yaeger.showcase {
    requires hanyaeger;

    exports com.github.hanyaeger.showcase;
    exports com.github.hanyaeger.showcase.scenes.mapsandlegends.tilemaps.entities;
    exports com.github.hanyaeger.showcase.scenes.gravity.tilemaps.entities;
    exports com.github.hanyaeger.showcase.scenes.scrollingstones.entities;

    opens audio;
    opens backgrounds;
    opens entities;
    opens fonts;
}
