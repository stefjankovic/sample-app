@TypeDef(
        name = "json", typeClass = JsonType.class
)
@TypeDef(
        name = "list-array",
        typeClass = ListArrayType.class
)
package com.sjankovic.sampleapp.entities;

import com.vladmihalcea.hibernate.type.array.ListArrayType;
import com.vladmihalcea.hibernate.type.json.JsonType;
import org.hibernate.annotations.TypeDef;