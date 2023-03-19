package com.example.shopping.body;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ImageBody {
    private String fileName;
    private String downloadUri;
    private long size;
}
