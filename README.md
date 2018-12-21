# sbt-scalavista

The sbt plugin companion for the [scalavista](https://github.com/buntec/scalavista) Scala language-server 
and the [neovim-scalavista](https://github.com/buntec/neovim-scalavista) Neovim plugin.
Please refer to those projects for more information.

## Install

The plugin should soon be hosted on Bintray after which it can be consumed with a simple `addSbtPlugin`. 
Until then you have to build it yourself and publish it locally:

```
sbt publishLocal
```

Then add this to your `project/plugins.sbt`:

```
addSbtPlugin("org.scalavista" % "sbt-scalavista" % "0.1.0")
```

## Usage

```
sbt generateScalavistaConfig
```

This produces a `scalavista.json` file at the root of your project. That's it. 

## Disclaimer

This project is in alpha stage and should be considered unstable.
