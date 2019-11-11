package com.algorithm.sort;

import java.util.Objects;

public class SelectionSorter<T extends Comparable<T>> implements Sorter<T> {

    @Override
    public void sort(T[] items) {
        Objects.requireNonNull(items);

        // 外层移动基准元素索引
        for (int i = 0; i < items.length - 1; i++) {
            int minValueIndex = i;

            // 内层对基准元素与之后的每个做比较，冒泡排序
            for (int j = i + 1; j < items.length; j++) {

                // 选择之后的元素中最小的值
                if (this.less(items[j], items[minValueIndex])) {
                    minValueIndex = j;
                }
            }

            // 之后的元素中最小的值，换到外层当前位置（最左边）
            this.swap(items, minValueIndex, i);
        }
    }
}
