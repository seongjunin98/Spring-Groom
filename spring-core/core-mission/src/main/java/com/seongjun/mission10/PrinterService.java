package com.seongjun.mission10;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PrinterService {

    private final Printer printer;

    @Autowired

    public PrinterService(@Qualifier("filePrinter") Printer printer) {
        this.printer = printer;
    }

    public void doPrint() {
        printer.print("출력입니다.");
    }
}
