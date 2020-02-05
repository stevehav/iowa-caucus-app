package com.fasterxml.jackson.core.async;

public interface NonBlockingInputFeeder {
    void endOfInput();

    boolean needMoreInput();
}
