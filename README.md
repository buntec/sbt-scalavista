# sbt-scalavista

The sbt plugin companion for the [scalavista](https://github.com/buntec/scalavista) Scala language-server 
and the [neovim-scalavista](https://github.com/buntec/neovim-scalavista) Neovim plugin.
Please refer to those projects for more information.


## Usage

Add this to `project/plugins.sbt`:

```
addSbtPlugin("org.scalavista" % "sbt-scalavista" % "0.1.0")
```

Then run:

```
sbt generateScalavistaConfig
```

This produces a `scalavista.json` file at the root of your project. That's it. 

## Disclaimer

This project is in alpha stage and should be considered unstable.
