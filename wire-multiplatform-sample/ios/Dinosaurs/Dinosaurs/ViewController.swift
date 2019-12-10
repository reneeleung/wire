//
//  ViewController.swift
//  Dinosaurs
//
//  Created by Egor Andreevici on 2019-12-03.
//  Copyright © 2019 Square. All rights reserved.
//

import UIKit
import protos

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        
        let encodedDino = "CgtTdGVnb3NhdXJ1cxIUaHR0cDovL2dvby5nbC9MRDVLWTUSFGh0dHA6Ly9nb28uZ2wvVllSTTY3GQAAAAAAACJAIQAAAAAAiLNAKAI="
        let nsData = NSData(base64Encoded: encodedDino, options: .ignoreUnknownCharacters)!
        let dinoBytes = OkioKt.decodeBase64(base64: nsData.base64EncodedString(options: .endLineWithCarriageReturn))
        let decodedDino = Dinosaur.Companion.init().ADAPTER.decode(bytes_: dinoBytes) as? Dinosaur
        
        if let dino = decodedDino {
            let nameLabel = UILabel(frame: CGRect(x: 20, y: 100, width: 300, height: 35))
            nameLabel.textAlignment = .left
            nameLabel.font = nameLabel.font.withSize(25)
            nameLabel.text = "Name: \(dino.name!)"
            view.addSubview(nameLabel)
            
            let lengthLabel = UILabel(frame: CGRect(x: 20, y: 150, width: 300, height: 35))
            lengthLabel.textAlignment = .left
            lengthLabel.font = lengthLabel.font.withSize(25)
            lengthLabel.text = "Length in meters: \(dino.length_meters!.stringValue)"
            view.addSubview(lengthLabel)
            
            let massLabel = UILabel(frame: CGRect(x: 20, y: 200, width: 300, height: 35))
            massLabel.textAlignment = .left
            massLabel.font = massLabel.font.withSize(25)
            massLabel.text = "Mass in kg: \(dino.mass_kilograms!.stringValue)"
            view.addSubview(massLabel)
            
            let periodLabel = UILabel(frame: CGRect(x: 20, y: 250, width: 300, height: 35))
            periodLabel.textAlignment = .left
            periodLabel.font = periodLabel.font.withSize(25)
            periodLabel.text = "Period: \(dino.period!)"
            view.addSubview(periodLabel)
        }
    }
}
