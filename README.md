# Example Mod

This is an example Mod.

Multiloader Minecraft mod for **Fabric, Forge, NeoForge** on Minecraft **26.3**.
Generated from the [Multiloader Template](https://github.com/Morthen-Mods/Multiloader-Template), which builds on the [multiloader-gradle-plugin](https://github.com/Morthen-Mods/multiloader-gradle-plugin).

## Requirements

- JDK 25 (Gradle's toolchain support downloads one automatically if it is missing)
- Git

## Project layout

| Module | Purpose |
| --- | --- |
| `common` | Loader-independent code and resources. Compiled into every loader jar. |
| `datagen` | Data generators (run on NeoForge). Output is written to `common/src/generated`. |
| `fabric` | Fabric entrypoint, `fabric.mod.json` and Fabric-only code. |
| `forge` | Forge entrypoint, `mods.toml` and Forge-only code. |
| `neoforge` | NeoForge entrypoint, `neoforge.mods.toml` and NeoForge-only code. |

Loader-specific behaviour is accessed from common code through the `IPlatformHelper` service
(`com.example.example_mod.service.Services.PLATFORM`).

## Building

```
./gradlew build
```

The mod jars end up in `<loader>/build/libs/`.

## Running

Run configurations are generated for IntelliJ IDEA; on the command line use the Gradle tasks below.
Game directories live in `common/runs/`.

| Task | Description |
| --- | --- |
| `:fabric:runClient` / `:fabric:runServer` | Fabric client / server |
| `:forge:runClient` / `:forge:runServer` | Forge client / server |
| `:neoforge:runClient` / `:neoforge:runServer` | NeoForge client / server |
| `:<loader>:runTestmodClient` / `runTestmodServer` | Same, with the `testmod` source set loaded as a second mod |
| `:fabric:runGameTests` | Run the game tests on Fabric |
| `:forge:runGametestGameTestServer` | Run the game tests on Forge (generates test instances via `:forge:runGametestData` first) |
| `:neoforge:runGameTests` | Run the game tests on NeoForge |
| `:datagen:runData` | Run data generation; writes into `common/src/generated` |

## Publishing

Publishing uses [mod-publish-plugin](https://github.com/modmuss50/mod-publish-plugin).
Set the `MODRINTH_API` and/or `CURSEFORGE_API` environment variables (and the matching
`modrinth_id` / `curseforge_id` in `gradle.properties`), then run:

```
./gradlew publishMods
```

A platform is used as soon as its `modrinth_id` / `curseforge_id` entry exists in `gradle.properties`,
so remove the entry of a platform you don't publish to. `CHANGELOG.md` is used as the release changelog.
Add `-Pmod_publish_dry_run=true` to test the upload without publishing anything.

## License

This project is licensed under the MIT license. See `LICENSE`.
