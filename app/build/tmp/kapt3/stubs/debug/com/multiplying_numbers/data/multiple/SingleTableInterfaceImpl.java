package com.multiplying_numbers.data.multiple;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\tH\u0016J\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0011H\u0002J(\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u000fH\u0002J\u001e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00112\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0002J\u0018\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u000fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/multiplying_numbers/data/multiple/SingleTableInterfaceImpl;", "Lcom/multiplying_numbers/data/multiple/SingleTableInterface;", "signal", "Lcom/multiplying_numbers/data/multiple/WrongAnswerSignal;", "(Lcom/multiplying_numbers/data/multiple/WrongAnswerSignal;)V", "checkAnswer", "Lcom/multiplying_numbers/domain/multiple/models/ModelSingleTab;", "modelSingleTab", "answer", "", "checkLeftAnswer", "checkRightAnswer", "getListTables", "idTable", "getRandomModelForNextQuestion", "Lcom/multiplying_numbers/domain/multiple/models/ModelQuestions;", "listModelQuestions", "", "getSingleTabModel", "modelForQuestions", "setAnswerInModelAndgetListModelQuestions", "setValueInModelIfAnswerCorrect", "modelQuestion", "setValueInModelIfAnswerWrong", "app_debug"})
public final class SingleTableInterfaceImpl implements com.multiplying_numbers.data.multiple.SingleTableInterface {
    @org.jetbrains.annotations.NotNull
    private final com.multiplying_numbers.data.multiple.WrongAnswerSignal signal = null;
    
    @javax.inject.Inject
    public SingleTableInterfaceImpl(@org.jetbrains.annotations.NotNull
    com.multiplying_numbers.data.multiple.WrongAnswerSignal signal) {
        super();
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public com.multiplying_numbers.domain.multiple.models.ModelSingleTab getListTables(int idTable) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public com.multiplying_numbers.domain.multiple.models.ModelSingleTab checkLeftAnswer(@org.jetbrains.annotations.NotNull
    com.multiplying_numbers.domain.multiple.models.ModelSingleTab modelSingleTab) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public com.multiplying_numbers.domain.multiple.models.ModelSingleTab checkRightAnswer(@org.jetbrains.annotations.NotNull
    com.multiplying_numbers.domain.multiple.models.ModelSingleTab modelSingleTab) {
        return null;
    }
    
    /**
     * otherfun__________________________________________________________________________________
     */
    private final com.multiplying_numbers.domain.multiple.models.ModelSingleTab checkAnswer(com.multiplying_numbers.domain.multiple.models.ModelSingleTab modelSingleTab, int answer) {
        return null;
    }
    
    private final com.multiplying_numbers.domain.multiple.models.ModelSingleTab getSingleTabModel(com.multiplying_numbers.domain.multiple.models.ModelSingleTab modelSingleTab, java.util.List<com.multiplying_numbers.domain.multiple.models.ModelQuestions> listModelQuestions, com.multiplying_numbers.domain.multiple.models.ModelQuestions modelForQuestions) {
        return null;
    }
    
    private final java.util.List<com.multiplying_numbers.domain.multiple.models.ModelQuestions> setAnswerInModelAndgetListModelQuestions(com.multiplying_numbers.domain.multiple.models.ModelSingleTab modelSingleTab, int answer) {
        return null;
    }
    
    private final com.multiplying_numbers.domain.multiple.models.ModelQuestions getRandomModelForNextQuestion(java.util.List<com.multiplying_numbers.domain.multiple.models.ModelQuestions> listModelQuestions) {
        return null;
    }
    
    private final com.multiplying_numbers.domain.multiple.models.ModelQuestions setValueInModelIfAnswerCorrect(com.multiplying_numbers.domain.multiple.models.ModelQuestions modelQuestion, int answer) {
        return null;
    }
    
    private final com.multiplying_numbers.domain.multiple.models.ModelQuestions setValueInModelIfAnswerWrong(com.multiplying_numbers.domain.multiple.models.ModelQuestions modelQuestion) {
        return null;
    }
}