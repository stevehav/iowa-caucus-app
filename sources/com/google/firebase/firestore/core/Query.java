package com.google.firebase.firestore.core;

import com.google.firebase.firestore.core.Filter;
import com.google.firebase.firestore.core.OrderBy;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.ResourcePath;
import com.google.firebase.firestore.util.Assert;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public final class Query {
    private static final OrderBy KEY_ORDERING_ASC = OrderBy.getInstance(OrderBy.Direction.ASCENDING, FieldPath.KEY_PATH);
    private static final OrderBy KEY_ORDERING_DESC = OrderBy.getInstance(OrderBy.Direction.DESCENDING, FieldPath.KEY_PATH);
    public static final long NO_LIMIT = -1;
    @Nullable
    private final String collectionGroup;
    @Nullable
    private final Bound endAt;
    private final List<OrderBy> explicitSortOrder;
    private final List<Filter> filters;
    private final long limit;
    private List<OrderBy> memoizedOrderBy;
    private final ResourcePath path;
    @Nullable
    private final Bound startAt;

    public static Query atPath(ResourcePath resourcePath) {
        return new Query(resourcePath, (String) null);
    }

    public Query(ResourcePath resourcePath, @Nullable String str, List<Filter> list, List<OrderBy> list2, long j, @Nullable Bound bound, @Nullable Bound bound2) {
        this.path = resourcePath;
        this.collectionGroup = str;
        this.explicitSortOrder = list2;
        this.filters = list;
        this.limit = j;
        this.startAt = bound;
        this.endAt = bound2;
    }

    public Query(ResourcePath resourcePath, @Nullable String str) {
        this(resourcePath, str, Collections.emptyList(), Collections.emptyList(), -1, (Bound) null, (Bound) null);
    }

    public ResourcePath getPath() {
        return this.path;
    }

    @Nullable
    public String getCollectionGroup() {
        return this.collectionGroup;
    }

    public boolean isDocumentQuery() {
        return DocumentKey.isDocumentKey(this.path) && this.collectionGroup == null && this.filters.isEmpty();
    }

    public boolean isCollectionGroupQuery() {
        return this.collectionGroup != null;
    }

    public List<Filter> getFilters() {
        return this.filters;
    }

    public long getLimit() {
        Assert.hardAssert(hasLimit(), "Called getLimit when no limit was set", new Object[0]);
        return this.limit;
    }

    public boolean hasLimit() {
        return this.limit != -1;
    }

    @Nullable
    public Bound getStartAt() {
        return this.startAt;
    }

    @Nullable
    public Bound getEndAt() {
        return this.endAt;
    }

    public FieldPath getFirstOrderByField() {
        if (this.explicitSortOrder.isEmpty()) {
            return null;
        }
        return this.explicitSortOrder.get(0).getField();
    }

    @Nullable
    public FieldPath inequalityField() {
        for (Filter next : this.filters) {
            if (next instanceof FieldFilter) {
                FieldFilter fieldFilter = (FieldFilter) next;
                if (fieldFilter.isInequality()) {
                    return fieldFilter.getField();
                }
            }
        }
        return null;
    }

    @Nullable
    public Filter.Operator findFilterOperator(List<Filter.Operator> list) {
        for (Filter next : this.filters) {
            if (next instanceof FieldFilter) {
                Filter.Operator operator = ((FieldFilter) next).getOperator();
                if (list.contains(operator)) {
                    return operator;
                }
            }
        }
        return null;
    }

    public Query filter(Filter filter) {
        boolean z = true;
        Assert.hardAssert(!isDocumentQuery(), "No filter is allowed for document query", new Object[0]);
        FieldPath fieldPath = null;
        if ((filter instanceof FieldFilter) && ((FieldFilter) filter).isInequality()) {
            fieldPath = filter.getField();
        }
        FieldPath inequalityField = inequalityField();
        Assert.hardAssert(inequalityField == null || fieldPath == null || inequalityField.equals(fieldPath), "Query must only have one inequality field", new Object[0]);
        if (!this.explicitSortOrder.isEmpty() && fieldPath != null && !this.explicitSortOrder.get(0).field.equals(fieldPath)) {
            z = false;
        }
        Assert.hardAssert(z, "First orderBy must match inequality field", new Object[0]);
        ArrayList arrayList = new ArrayList(this.filters);
        arrayList.add(filter);
        return new Query(this.path, this.collectionGroup, arrayList, this.explicitSortOrder, this.limit, this.startAt, this.endAt);
    }

    public Query orderBy(OrderBy orderBy) {
        FieldPath inequalityField;
        Assert.hardAssert(!isDocumentQuery(), "No ordering is allowed for document query", new Object[0]);
        if (!this.explicitSortOrder.isEmpty() || (inequalityField = inequalityField()) == null || inequalityField.equals(orderBy.field)) {
            ArrayList arrayList = new ArrayList(this.explicitSortOrder);
            arrayList.add(orderBy);
            return new Query(this.path, this.collectionGroup, this.filters, arrayList, this.limit, this.startAt, this.endAt);
        }
        throw Assert.fail("First orderBy must match inequality field", new Object[0]);
    }

    public Query limit(long j) {
        return new Query(this.path, this.collectionGroup, this.filters, this.explicitSortOrder, j, this.startAt, this.endAt);
    }

    public Query startAt(Bound bound) {
        return new Query(this.path, this.collectionGroup, this.filters, this.explicitSortOrder, this.limit, bound, this.endAt);
    }

    public Query endAt(Bound bound) {
        return new Query(this.path, this.collectionGroup, this.filters, this.explicitSortOrder, this.limit, this.startAt, bound);
    }

    public Query asCollectionQueryAtPath(ResourcePath resourcePath) {
        return new Query(resourcePath, (String) null, this.filters, this.explicitSortOrder, this.limit, this.startAt, this.endAt);
    }

    public List<OrderBy> getExplicitOrderBy() {
        return this.explicitSortOrder;
    }

    public List<OrderBy> getOrderBy() {
        OrderBy.Direction direction;
        if (this.memoizedOrderBy == null) {
            FieldPath inequalityField = inequalityField();
            FieldPath firstOrderByField = getFirstOrderByField();
            boolean z = false;
            if (inequalityField == null || firstOrderByField != null) {
                ArrayList arrayList = new ArrayList();
                for (OrderBy next : this.explicitSortOrder) {
                    arrayList.add(next);
                    if (next.getField().equals(FieldPath.KEY_PATH)) {
                        z = true;
                    }
                }
                if (!z) {
                    if (this.explicitSortOrder.size() > 0) {
                        List<OrderBy> list = this.explicitSortOrder;
                        direction = list.get(list.size() - 1).getDirection();
                    } else {
                        direction = OrderBy.Direction.ASCENDING;
                    }
                    arrayList.add(direction.equals(OrderBy.Direction.ASCENDING) ? KEY_ORDERING_ASC : KEY_ORDERING_DESC);
                }
                this.memoizedOrderBy = arrayList;
            } else if (inequalityField.isKeyField()) {
                this.memoizedOrderBy = Collections.singletonList(KEY_ORDERING_ASC);
            } else {
                this.memoizedOrderBy = Arrays.asList(new OrderBy[]{OrderBy.getInstance(OrderBy.Direction.ASCENDING, inequalityField), KEY_ORDERING_ASC});
            }
        }
        return this.memoizedOrderBy;
    }

    private boolean matchesPathAndCollectionGroup(Document document) {
        ResourcePath path2 = document.getKey().getPath();
        if (this.collectionGroup != null) {
            if (!document.getKey().hasCollectionId(this.collectionGroup) || !this.path.isPrefixOf(path2)) {
                return false;
            }
            return true;
        } else if (DocumentKey.isDocumentKey(this.path)) {
            return this.path.equals(path2);
        } else {
            if (!this.path.isPrefixOf(path2) || this.path.length() != path2.length() - 1) {
                return false;
            }
            return true;
        }
    }

    private boolean matchesFilters(Document document) {
        for (Filter matches : this.filters) {
            if (!matches.matches(document)) {
                return false;
            }
        }
        return true;
    }

    private boolean matchesOrderBy(Document document) {
        for (OrderBy next : this.explicitSortOrder) {
            if (!next.getField().equals(FieldPath.KEY_PATH) && document.getField(next.field) == null) {
                return false;
            }
        }
        return true;
    }

    private boolean matchesBounds(Document document) {
        Bound bound = this.startAt;
        if (bound != null && !bound.sortsBeforeDocument(getOrderBy(), document)) {
            return false;
        }
        Bound bound2 = this.endAt;
        if (bound2 == null || !bound2.sortsBeforeDocument(getOrderBy(), document)) {
            return true;
        }
        return false;
    }

    public boolean matches(Document document) {
        return matchesPathAndCollectionGroup(document) && matchesOrderBy(document) && matchesFilters(document) && matchesBounds(document);
    }

    public Comparator<Document> comparator() {
        return new QueryComparator(getOrderBy());
    }

    /* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
    private static class QueryComparator implements Comparator<Document> {
        private final List<OrderBy> sortOrder;

        QueryComparator(List<OrderBy> list) {
            boolean z;
            Iterator<OrderBy> it = list.iterator();
            loop0:
            while (true) {
                z = false;
                while (true) {
                    if (!it.hasNext()) {
                        break loop0;
                    }
                    OrderBy next = it.next();
                    if (z || next.getField().equals(FieldPath.KEY_PATH)) {
                        z = true;
                    }
                }
            }
            if (z) {
                this.sortOrder = list;
                return;
            }
            throw new IllegalArgumentException("QueryComparator needs to have a key ordering");
        }

        public int compare(Document document, Document document2) {
            for (OrderBy compare : this.sortOrder) {
                int compare2 = compare.compare(document, document2);
                if (compare2 != 0) {
                    return compare2;
                }
            }
            return 0;
        }
    }

    public String getCanonicalId() {
        StringBuilder sb = new StringBuilder();
        sb.append(getPath().canonicalString());
        if (this.collectionGroup != null) {
            sb.append("|cg:");
            sb.append(this.collectionGroup);
        }
        sb.append("|f:");
        for (Filter canonicalId : getFilters()) {
            sb.append(canonicalId.getCanonicalId());
        }
        sb.append("|ob:");
        for (OrderBy next : getOrderBy()) {
            sb.append(next.getField().canonicalString());
            sb.append(next.getDirection().equals(OrderBy.Direction.ASCENDING) ? "asc" : "desc");
        }
        if (hasLimit()) {
            sb.append("|l:");
            sb.append(getLimit());
        }
        if (this.startAt != null) {
            sb.append("|lb:");
            sb.append(this.startAt.canonicalString());
        }
        if (this.endAt != null) {
            sb.append("|ub:");
            sb.append(this.endAt.canonicalString());
        }
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Query query = (Query) obj;
        String str = this.collectionGroup;
        if (str == null ? query.collectionGroup != null : !str.equals(query.collectionGroup)) {
            return false;
        }
        if (this.limit != query.limit || !getOrderBy().equals(query.getOrderBy()) || !this.filters.equals(query.filters) || !this.path.equals(query.path)) {
            return false;
        }
        Bound bound = this.startAt;
        if (bound == null ? query.startAt != null : !bound.equals(query.startAt)) {
            return false;
        }
        Bound bound2 = this.endAt;
        if (bound2 != null) {
            return bound2.equals(query.endAt);
        }
        if (query.endAt == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = getOrderBy().hashCode() * 31;
        String str = this.collectionGroup;
        int i = 0;
        int hashCode2 = str != null ? str.hashCode() : 0;
        long j = this.limit;
        int hashCode3 = (((((((hashCode + hashCode2) * 31) + this.filters.hashCode()) * 31) + this.path.hashCode()) * 31) + ((int) (j ^ (j >>> 32)))) * 31;
        Bound bound = this.startAt;
        int hashCode4 = (hashCode3 + (bound != null ? bound.hashCode() : 0)) * 31;
        Bound bound2 = this.endAt;
        if (bound2 != null) {
            i = bound2.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Query(");
        sb.append(this.path.canonicalString());
        if (this.collectionGroup != null) {
            sb.append(" collectionGroup=");
            sb.append(this.collectionGroup);
        }
        if (!this.filters.isEmpty()) {
            sb.append(" where ");
            for (int i = 0; i < this.filters.size(); i++) {
                if (i > 0) {
                    sb.append(" and ");
                }
                sb.append(this.filters.get(i).toString());
            }
        }
        if (!this.explicitSortOrder.isEmpty()) {
            sb.append(" order by ");
            for (int i2 = 0; i2 < this.explicitSortOrder.size(); i2++) {
                if (i2 > 0) {
                    sb.append(", ");
                }
                sb.append(this.explicitSortOrder.get(i2));
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
