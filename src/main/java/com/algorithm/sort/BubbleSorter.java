package com.algorithm.sort;

import java.util.Objects;

public class BubbleSorter<T extends Comparable<T>> implements Sorter<T> {

    @Override
    public void sort(T[] items) {
        Objects.requireNonNull(items);

        // 外层移动基准元素索引
        for (int i = 0; i < items.length - 1; i++) {

            // 外层基准元素与之后的每个做比较，冒泡排序
            for (int j = i + 1; j < items.length; j++) {

                // 如果外层基准元素内层元素较大，换到后面，向上冒泡；小的换到前面
                if (this.greater(items[i], items[j])) {
                    this.swap(items, i, j);
                }
            }
        }
    }
}
