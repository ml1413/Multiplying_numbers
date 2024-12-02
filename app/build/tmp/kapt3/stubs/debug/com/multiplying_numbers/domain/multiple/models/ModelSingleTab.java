package com.multiplying_numbers.domain.multiple.models;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b&\b\u0086\b\u0018\u00002\u00020\u0001Bu\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0014J\t\u0010$\u001a\u00020\u0003H\u00c6\u0003J\t\u0010%\u001a\u00020\u0003H\u00c6\u0003J\t\u0010&\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\'\u001a\u00020\u0003H\u00c6\u0003J\t\u0010(\u001a\u00020\u0003H\u00c6\u0003J\t\u0010)\u001a\u00020\u0006H\u00c6\u0003J\t\u0010*\u001a\u00020\u0006H\u00c6\u0003J\u000f\u0010+\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u00c6\u0003J\t\u0010,\u001a\u00020\fH\u00c6\u0003J\t\u0010-\u001a\u00020\u0006H\u00c6\u0003J\t\u0010.\u001a\u00020\u000fH\u00c6\u0003J\t\u0010/\u001a\u00020\u0003H\u00c6\u0003J\u0087\u0001\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u0003H\u00c6\u0001J\u0013\u00101\u001a\u00020\u00062\b\u00102\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00103\u001a\u00020\u0003H\u00d6\u0001J\t\u00104\u001a\u00020\u000fH\u00d6\u0001R\u0011\u0010\u0010\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0013\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u001bR\u0011\u0010\r\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u001bR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0011\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0016R\u0011\u0010\u0012\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0016\u00a8\u00065"}, d2 = {"Lcom/multiplying_numbers/domain/multiple/models/ModelSingleTab;", "", "idTable", "", "idQuestion", "hasWrongAnswer", "", "isAllAnswerCorrect", "listModelQuestions", "", "Lcom/multiplying_numbers/domain/multiple/models/ModelQuestions;", "colorCountWrongAnswer", "Lcom/multiplying_numbers/domain/multiple/models/ColorCountWrongAnswer;", "isPrintCountWrongAnswer", "questionString", "", "answerValue", "textForLeftButton", "textForRightButton", "countWrongAnswer", "(IIZZLjava/util/List;Lcom/multiplying_numbers/domain/multiple/models/ColorCountWrongAnswer;ZLjava/lang/String;IIII)V", "getAnswerValue", "()I", "getColorCountWrongAnswer", "()Lcom/multiplying_numbers/domain/multiple/models/ColorCountWrongAnswer;", "getCountWrongAnswer", "getHasWrongAnswer", "()Z", "getIdQuestion", "getIdTable", "getListModelQuestions", "()Ljava/util/List;", "getQuestionString", "()Ljava/lang/String;", "getTextForLeftButton", "getTextForRightButton", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app_debug"})
public final class ModelSingleTab {
    private final int idTable = 0;
    private final int idQuestion = 0;
    private final boolean hasWrongAnswer = false;
    private final boolean isAllAnswerCorrect = false;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.multiplying_numbers.domain.multiple.models.ModelQuestions> listModelQuestions = null;
    @org.jetbrains.annotations.NotNull
    private final com.multiplying_numbers.domain.multiple.models.ColorCountWrongAnswer colorCountWrongAnswer = null;
    private final boolean isPrintCountWrongAnswer = false;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String questionString = null;
    private final int answerValue = 0;
    private final int textForLeftButton = 0;
    private final int textForRightButton = 0;
    private final int countWrongAnswer = 0;
    
    public ModelSingleTab(int idTable, int idQuestion, boolean hasWrongAnswer, boolean isAllAnswerCorrect, @org.jetbrains.annotations.NotNull
    java.util.List<com.multiplying_numbers.domain.multiple.models.ModelQuestions> listModelQuestions, @org.jetbrains.annotations.NotNull
    com.multiplying_numbers.domain.multiple.models.ColorCountWrongAnswer colorCountWrongAnswer, boolean isPrintCountWrongAnswer, @org.jetbrains.annotations.NotNull
    java.lang.String questionString, int answerValue, int textForLeftButton, int textForRightButton, int countWrongAnswer) {
        super();
    }
    
    public final int getIdTable() {
        return 0;
    }
    
    public final int getIdQuestion() {
        return 0;
    }
    
    public final boolean getHasWrongAnswer() {
        return false;
    }
    
    public final boolean isAllAnswerCorrect() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.multiplying_numbers.domain.multiple.models.ModelQuestions> getListModelQuestions() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.multiplying_numbers.domain.multiple.models.ColorCountWrongAnswer getColorCountWrongAnswer() {
        return null;
    }
    
    public final boolean isPrintCountWrongAnswer() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getQuestionString() {
        return null;
    }
    
    public final int getAnswerValue() {
        return 0;
    }
    
    public final int getTextForLeftButton() {
        return 0;
    }
    
    public final int getTextForRightButton() {
        return 0;
    }
    
    public final int getCountWrongAnswer() {
        return 0;
    }
    
    public final int component1() {
        return 0;
    }
    
    public final int component10() {
        return 0;
    }
    
    public final int component11() {
        return 0;
    }
    
    public final int component12() {
        return 0;
    }
    
    public final int component2() {
        return 0;
    }
    
    public final boolean component3() {
        return false;
    }
    
    public final boolean component4() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.multiplying_numbers.domain.multiple.models.ModelQuestions> component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.multiplying_numbers.domain.multiple.models.ColorCountWrongAnswer component6() {
        return null;
    }
    
    public final boolean component7() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component8() {
        return null;
    }
    
    public final int component9() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.multiplying_numbers.domain.multiple.models.ModelSingleTab copy(int idTable, int idQuestion, boolean hasWrongAnswer, boolean isAllAnswerCorrect, @org.jetbrains.annotations.NotNull
    java.util.List<com.multiplying_numbers.domain.multiple.models.ModelQuestions> listModelQuestions, @org.jetbrains.annotations.NotNull
    com.multiplying_numbers.domain.multiple.models.ColorCountWrongAnswer colorCountWrongAnswer, boolean isPrintCountWrongAnswer, @org.jetbrains.annotations.NotNull
    java.lang.String questionString, int answerValue, int textForLeftButton, int textForRightButton, int countWrongAnswer) {
        return null;
    }
    
    @java.lang.Override
    public boolean equals(@org.jetbrains.annotations.Nullable
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        return null;
    }
}