package com.mtgcommandersimulator.bootstrap;
/** Bootstrap only; this is not a Magic rules engine. */
public final class Bootstrap {
    private Bootstrap() {}
    public static String identity() { return "MTG Commander Simulator/step-02-wip"; }
    public static void main(String[] args) { System.out.println(identity()); }
}
