package org.ligi.passandroid.model.comparator

import org.ligi.passandroid.model.pass.Pass
import java.util.*

enum class PassSortOrder constructor(val int: Int) {
    DATE_DESC(0),
    DATE_ASC(-1),
    TYPE(1),
    DATE_DIFF(2);

    fun toComparator(): Comparator<Pass> = when (this) {
        TYPE -> PassByTypeFirstAndTimeSecondComparator()
        DATE_DESC -> DirectionAwarePassByTimeComparator(DirectionAwarePassByTimeComparator.DIRECTION_DESC)
        DATE_DIFF -> PassTemporalDistanceComparator()
        DATE_ASC -> DirectionAwarePassByTimeComparator(DirectionAwarePassByTimeComparator.DIRECTION_ASC)
    }
}
