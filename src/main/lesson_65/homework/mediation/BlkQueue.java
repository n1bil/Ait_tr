package main.lesson_65.homework.mediation;

/**
 * This interface represents Blocking Queue for usage
 * as communication buffer between Producers and Consumers
 */
public interface BlkQueue<T> {
    void push(T message);
    T pop();
}
