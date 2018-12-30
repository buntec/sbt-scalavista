# sbt-scalavista

The sbt plugin companion for the [scalavista](https://github.com/buntec/scalavista) Scala language-server 
, the [neovim-scalavista](https://github.com/buntec/neovim-scalavista) Neovim plugin, and the
[vscode-scalavista](https://github.com/buntec/vscode-scalavista) Visual Studio Code extension.
Please refer to those projects for more information.


## Usage

Add this to `project/plugins.sbt` (or globally to `.sbt/1.0/plugins/plugins.sbt`):

```
addSbtPlugin("org.scalavista" % "sbt-scalavista" % "0.1.2")
```

For single-project builds simply run:

```
sbt generateScalavistaConfig
```

For multi-project builds you may try (experimental):

```
sbt generateCombinedScalavistaConfig
```

Either of the above produces a `scalavista.json` file at the root of your project. That's it. 

## Disclaimer

This project is in alpha stage and should be considered unstable.
