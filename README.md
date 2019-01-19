# sbt-scalavista

The sbt plugin companion for the [scalavista-server](https://github.com/buntec/scalavista-server) 
language-server, the [neovim-scalavista](https://github.com/buntec/neovim-scalavista) 
Neovim plugin, and the [vscode-scalavista](https://github.com/buntec/vscode-scalavista) 
Visual Studio Code extension. Please refer to those projects for more information.

## Usage

Add this to `project/plugins.sbt` (or globally to `.sbt/1.0/plugins/plugins.sbt`):

```
addSbtPlugin("org.scalavista" % "sbt-scalavista" % "0.1.4")
```

In most cases it suffices to run:

```
sbt generateScalavistaConfig
```

This task will combine your sources and dependencies across projects/configurations.
If you need more control you can use `generateScopedScalavistaConfig`,
which can be scoped, e.g., `projA / Test / generateScopedScalavistaConfig`.

Either of the above produces a `scalavista.json` file at the root of your project.
Re-generate it whenever the structure of your project changes (dependencies, compiler options, etc.).

## Known Issues

If the generated `scalavista.json` is corrupted (not a valid json), re-running the task
once or twice should do the trick.
