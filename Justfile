
all: make_all

package:
    cd dist/bluej && zip -r ../bluej.zip grpro_project
    cd dist/intellij && zip -r ../intellij.zip grpro_project
    cd dist/vscode && zip -r ../vscode.zip grpro_project

make_all: make_bluej make_intellij make_vscode

make_bluej:
    mkdir -p dist/bluej/grpro_project
    cp -r src/ dist/bluej/grpro_project/src
    cp -r docs/ dist/bluej/grpro_project/docs/
    cp -r resources/ dist/bluej/grpro_project/src/resources/
    cp -r lib/ dist/bluej/grpro_project/src/lib
    cp readme.md dist/bluej/grpro_project/

make_intellij:
    mkdir -p dist/intellij/grpro_project
    cp -r src/ dist/intellij/grpro_project/src
    cp -r docs/ dist/intellij/grpro_project/docs/
    cp -r resources/ dist/intellij/grpro_project/resources/
    cp -r lib/ dist/intellij/grpro_project/lib
    cp WorldSimulator.iml dist/intellij/grpro_project/
    cp readme.md dist/intellij/grpro_project/

make_vscode:
    mkdir -p dist/vscode/grpro_project
    cp -r src/ dist/vscode/grpro_project/src
    cp -r docs/ dist/vscode/grpro_project/docs/
    cp -r resources/ dist/vscode/grpro_project/resources/
    cp -r lib/ dist/vscode/grpro_project/lib
    cp readme.md dist/vscode/grpro_project/

inputs week:
    mkdir -p dist/files/{{week}}
    cp -r project/themes/{{week}}/*.txt dist/files/{{week}}
    cd dist/files && zip -r inputs_{{week}}.zip {{week}}


clean:
    rm -r dist
