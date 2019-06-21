/**
 *
 */
package com.etc.builder;

/**
 * @author user2
 *
 */
class BuilderSample {
    // (drink)
    // 引数のパターンが多い場合などに利用(コンストラクタを一つ一つ書いているとキリがないため)
    // final修飾子は子要素からな要をいじれない(この場合は子要素から見ると定数)
    // immutable && スレッドセーフ
    // 速度的にはマイナスだが、マルチスレッドプログラミングにおいてimmutableなオブジェクトは排他処理なしでアクセスできる
    // → 結果的には排他処理を書くよりも有利になることが多い.

    private final int servingSize; // (ml)
    private final int serving; // (容器あたり)必須
    private final int calories; // オプション カロリー
    private final int fat; // オプション 脂質
    private final int sodium; // オプション 塩分
    private final int carbohydrate; // オプション 炭水化物

    @Override
    public String toString() {
        return "BuilderSample [servingSize=" + this.servingSize + ", serving=" + this.serving + ", calories="
                + this.calories + ", fat=" + this.fat + ", sodium=" + this.sodium + ", carbohydrate="
                + this.carbohydrate + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + this.calories;
        result = prime * result + this.carbohydrate;
        result = prime * result + this.fat;
        result = prime * result + this.serving;
        result = prime * result + this.servingSize;
        result = prime * result + this.sodium;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        BuilderSample other = (BuilderSample) obj;
        if (this.calories != other.calories)
            return false;
        if (this.carbohydrate != other.carbohydrate)
            return false;
        if (this.fat != other.fat)
            return false;
        if (this.serving != other.serving)
            return false;
        if (this.servingSize != other.servingSize)
            return false;
        if (this.sodium != other.sodium)
            return false;
        return true;
    }

    static class Builder {
        // 必須
        private final int serviceSize;
        private final int servings;

        // オプション
        private int calories;
        private int fat;
        private int sodium;
        private int carbohydrate;

        public Builder(int servingSize, int servings) {
            this.serviceSize = servingSize;
            this.servings = servings;
        }

        // 高速化(finalを付けることで) アクセッサに

        public final Builder setCalories(int val) {
            calories = val;
            return this;
        }

        public final Builder setFat(int val) {
            fat = val;
            return this;
        }

        public final Builder setSodium(int val) {
            sodium = val;
            return this;
        }

        public final Builder setCarbohydrate(int val) {
            carbohydrate = val;
            return this;
        }

        public final BuilderSample build() {
            return new BuilderSample(this);
        }

    }

    private BuilderSample(Builder builder) {
        this.servingSize = builder.serviceSize;
        this.serving = builder.servings;
        this.calories = builder.calories;
        this.fat = builder.fat;
        this.sodium = builder.sodium;
        this.carbohydrate = builder.carbohydrate;
    }

}
