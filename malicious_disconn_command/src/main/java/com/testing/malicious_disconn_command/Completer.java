//package com.testing.malicious_disconn_command;
//
//import org.apache.karaf.shell.api.action.lifecycle.Service;
//import org.apache.karaf.shell.api.console.CommandLine;
//import org.apache.karaf.shell.api.console.Completer;
//import org.apache.karaf.shell.api.console.Session;
//import org.apache.karaf.shell.support.completers.StringsCompleter;
//
//
//@Service
//public class Completer implements Completer {
//
//    public int complete(Session session, CommandLine commandLine, List<String> candidates) {
//        StringsCompleter delegate = new StringsCompleter();
//        delegate.getStrings().add("Mike");
//        delegate.getStrings().add("Eric");
//        delegate.getStrings().add("Jenny");
//        return delegate.complete(buffer, cursor, candidates);
//    }
//
//}