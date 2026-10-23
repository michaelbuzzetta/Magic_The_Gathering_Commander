package com.quantumchronos.bootstrap;

/** Dependency-free assertion test. No false rules-engine coverage claims. */
public final class BootstrapTest {
    private BootstrapTest() { }
    public static void main(String[] args) {
        if (!"QuantumChronOS/step-01".equals(Bootstrap.identity())) {
            throw new AssertionError("Bootstrap identity mismatch");
        }
        System.out.println("PASS BootstrapTest");
    }
}
