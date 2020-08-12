package br.com.boraviajar.apimanager.usecase.rule;

public interface Rule<T> {

    void validate(T value);

}
